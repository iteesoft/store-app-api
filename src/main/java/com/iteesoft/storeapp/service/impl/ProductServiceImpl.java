package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.dto.ProductDto;
import com.iteesoft.storeapp.exceptions.AlreadyExistException;
import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;
import com.iteesoft.storeapp.model.TransactionItem;
import com.iteesoft.storeapp.repository.CategoryRepository;
import com.iteesoft.storeapp.repository.ProductRepository;
import com.iteesoft.storeapp.service.ProductService;
import com.iteesoft.storeapp.service.UtilService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final UtilService utilService;

    @Override
    @Transactional
    public Product saveProduct(ProductDto product) {
        checkIfProductExist(product.getProductName(), product.getDescription());
        Product newProduct = Product.builder().name(product.getProductName())
                .price(product.getPrice()).imageUrl(product.getImageUrl())
                .quantity(product.getQuantity()).build();
            // check for existing or create new category
        Optional<Category> category = categoryRepository.findByName(product.getCategoryName());
        category.ifPresent(m-> m.getProducts().add(newProduct));
        log.info("Product with name : {}", product.getProductName()+" Created!");
        return newProduct;

    }

    private void checkIfProductExist(String name, String description) {
        if (productRepository.existsByNameAndDescription(name, description)) {
            log.error("Unable to create. A Product with name {} exist ", name);
            throw new AlreadyExistException("Product already exist", "check the details and try again");
        }
    }

    @Override
    public Product update(Long productId, ProductDto updateInfo) {
        Product existingProduct = utilService.getProductById(productId);
        log.info("Updating Product with id : {}", productId);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(updateInfo, existingProduct);

        existingProduct.setUpdatedAt(LocalDateTime.now());
        productRepository.save(existingProduct);
        return existingProduct;
    }


    @Override
    public void delete(Long id) throws NotFoundException {
        log.info("Fetching and Deleting Product with id {}", id);
        utilService.getProductById(id);

        log.info("Product with id {} Deleted", id);
        productRepository.deleteById(id);
    }

    @Override
    public Product viewProduct(Long id) {
        return utilService.getProductById(id);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }


    @Override
    @Transactional
    public Category addProductToCategory(Long productId, Long categoryId) {
        Product product = utilService.getProductById(productId);
        Category category = utilService.getCategoryById(categoryId);
        category.getProducts().add(product);
        categoryRepository.save(category);
        log.info("Product: "+product.getName()+" successfully added to category: "+category.getName());
        return category;
    }

    public void createTransaction(Long productId) {
        Product product = productRepository.findById(productId).get();
        TransactionItem item = TransactionItem.builder().productName(product.getName())
                .quantity(1).price(product.getPrice()).build();

    }
}