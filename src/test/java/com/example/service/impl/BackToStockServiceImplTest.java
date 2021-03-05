package com.example.service.impl;

import com.example.model.Product;
import com.example.model.ProductCategory;
import com.example.model.User;
import com.example.service.BackToStockService;
import com.example.service.ProductService;
import com.example.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BackToStockServiceImplTest {
    @Autowired
    private BackToStockService backToStockService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Test
    void subscribe() {
        User leo = new User();
        leo.setName("Leo");
        leo.setEmail("leo@mail.com");
        userService.save(leo);

        Product cleanCode = new Product();
        cleanCode.setName("Clean code");
        cleanCode.setCategory(ProductCategory.BOOKS);
        productService.save(cleanCode);

        backToStockService.subscribe(cleanCode, leo);

        List<User> users = backToStockService.subscribedUsers(cleanCode);
        Assertions.assertEquals(List.of(leo), users);
    }

    @Test
    void unsubscribe() {
        Product product = productService.findByName("Clean code");
        User leo = userService.findByEmail("leo@mail.com");
        backToStockService.unsubscribe(product, leo);

        Assertions.assertFalse(backToStockService.subscribedUsers(product).contains(leo));
    }

    @Test
    void subscribedUsers() {
        User alex = new User();
        alex.setName("Alex");
        alex.setEmail("alex@mail.com");
        userService.save(alex);

        User alice = new User();
        alice.setName("Alice");
        alice.setEmail("alice@mail.com");
        userService.save(alice);

        User lia = new User();
        lia.setName("Lia");
        lia.setEmail("lia@mail.com");
        userService.save(lia);

        Product cleanCode = new Product();
        cleanCode.setName("Titans");
        cleanCode.setCategory(ProductCategory.BOOKS);
        productService.save(cleanCode);

        backToStockService.subscribe(cleanCode, alex);
        backToStockService.subscribe(cleanCode, alice);
        backToStockService.subscribe(cleanCode, lia);

        Assertions.assertEquals(List.of(alex, alice, lia), backToStockService.subscribedUsers(cleanCode));
    }
}
