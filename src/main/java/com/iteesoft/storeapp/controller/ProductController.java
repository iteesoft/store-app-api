package com.iteesoft.storeapp.controller;

import com.iteesoft.storeapp.dto.ProductDto;
import com.iteesoft.storeapp.model.Product;
import com.iteesoft.storeapp.payload.Response;
import com.iteesoft.storeapp.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import java.net.URI;
import java.util.Map;
import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Response> createProduct(@RequestBody ProductDto productInfo) {
        var product = productService.saveProduct(productInfo);
        URI uri = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).createProduct(productInfo)).toUri();
        return ResponseEntity.created(uri).body(Response.builder().status(CREATED)
                .data(Map.of("product", product)).build());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds Products by id", notes = "Provide an id to look up specific product from the store", response = Product.class)
    public ResponseEntity<?> viewProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.viewProduct(id), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.update(id, product), OK);
    }

    @GetMapping
    public ResponseEntity<?> viewAllProducts() {
        return new ResponseEntity<>(productService.viewAllProducts(), OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
