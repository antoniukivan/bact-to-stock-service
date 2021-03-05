package com.example.service;

import com.example.model.Product;
import com.example.model.ProductCategory;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);

    Product findByName(String name);

    List<Product> findAllByCategory(ProductCategory productCategory);

    void delete(Long id);
}
