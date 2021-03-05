package com.example.service;

import com.example.model.Product;
import com.example.model.User;
import java.util.List;

public interface BackToStockService {
    void subscribe(Product product, User user);

    void unsubscribe(Product product, User user);

    List<User> subscribedUsers(Product product);

    void notify(Product product);
}
