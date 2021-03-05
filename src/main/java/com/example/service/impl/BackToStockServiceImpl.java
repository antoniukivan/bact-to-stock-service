package com.example.service.impl;

import com.example.model.Product;
import com.example.model.ProductCategory;
import com.example.model.User;
import com.example.service.BackToStockService;
import com.example.service.MailSender;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BackToStockServiceImpl implements BackToStockService {
    private final MailSender mailSender;
    private final Map<Product, List<User>> listeners = new HashMap<>();

    public BackToStockServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void subscribe(Product product, User user) {
        listeners.computeIfAbsent(product,
                k -> new ArrayList<>());
        List<User> users = listeners.get(product);
        users.add(user);
    }

    @Override
    public void unsubscribe(Product product, User user) {
        List<User> users = listeners.get(product);
        users.remove(user);
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        return listeners.get(product);
    }

    @Override
    public void notify(Product product) {
        User user = listeners.get(product).stream().min(Comparator
                .comparing(User::isPremium)
                .reversed()
                .thenComparing(u -> u.getAge() < 70)
                .thenComparing(u -> product.getCategory() != ProductCategory.MEDICAL)).get();
        listeners.get(product).remove(user);

        mailSender.send(user.getEmail(), "AmazingCo",
                product.getName() + " back to the stock!");
    }
}
