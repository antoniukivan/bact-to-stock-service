package com.example.repository;

import com.example.model.Product;
import com.example.model.ProductCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findAllByCategory() {
        Product cleanCode = new Product();
        cleanCode.setName("Clean code");
        cleanCode.setCategory(ProductCategory.BOOKS);
        Product thinkingInJava = new Product();
        thinkingInJava.setName("Thinking in Java");
        thinkingInJava.setCategory(ProductCategory.BOOKS);

        List<Product> products = new ArrayList<>();
        products.add(cleanCode);
        products.add(thinkingInJava);

        productRepository.save(cleanCode);
        productRepository.save(thinkingInJava);

        List<Product> books = productRepository.findAllByCategory(ProductCategory.BOOKS);
        Assertions.assertEquals(products, books);
        books = productRepository.findAllByCategory(ProductCategory.MEDICAL);
        Assertions.assertEquals(Collections.emptyList(), books);
    }
}
