package com.example.controller;

import com.example.model.Product;
import com.example.model.dto.ProductRequestDto;
import com.example.model.dto.ProductResponseDto;
import com.example.service.ProductService;
import com.example.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public void save(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productMapper.getModelFromDto(productRequestDto);
        productService.save(product);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return productMapper.getDtoFromModel(product);
    }
}
