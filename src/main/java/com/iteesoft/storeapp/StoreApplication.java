package com.iteesoft.storeapp;

import com.iteesoft.storeapp.config.StorageProperties;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;
import com.iteesoft.storeapp.repository.ProductRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@SecurityScheme(name = "storeappapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@EnableConfigurationProperties(StorageProperties.class)
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    	@Bean
        CommandLineRunner run(ProductRepository productRepo) {
		return args -> {
			productRepo.save(Product.builder().name("Spaghetti").description("Big").price(new BigDecimal("350")).quantity(20L).imageUrl("http://localhost:8080/image/spghb.png").build());
			productRepo.save(Product.builder().name("Spaghetti").description("Small").price(new BigDecimal("330")).quantity(20L).imageUrl("http://localhost:8080/image/spghs.png").build());
			productRepo.save(Product.builder().name("Tin Milk").description("Three crown").price(new BigDecimal("350")).quantity(10L).imageUrl("http://localhost:8080/image/server2.png").build());
			productRepo.save(Product.builder().name("Tin Milk").description("Peak").price(new BigDecimal("350")).quantity(15L).imageUrl("http://localhost:8080/image/server2.png").build());
		};
	}
}
