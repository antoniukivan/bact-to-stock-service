package com.example.service.impl;

import com.example.model.Product;
import com.example.model.ProductCategory;
import com.example.repository.ProductRepository;
import com.example.service.BackToStockService;
import com.example.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BackToStockService backToStockService;

    @Override
    public Product save(Product product) {
        if (backToStockService.subscribedUsers(product) != null) {
            backToStockService.notify(product);
        }
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find user by id: " + id));
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("Can't find user by name: " + name));
    }

    @Override
    public List<Product> findAllByCategory(ProductCategory productCategory) {
        return productRepository.findAllByCategory(productCategory);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
