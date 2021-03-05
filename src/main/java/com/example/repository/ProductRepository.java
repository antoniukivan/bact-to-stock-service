package com.example.repository;

import com.example.model.Product;
import com.example.model.ProductCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(ProductCategory productCategory);

    Optional<Product> findByName(String name);
}
