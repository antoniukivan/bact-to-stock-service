package com.example.service.mapper;

import com.example.model.Product;
import com.example.model.ProductCategory;
import com.example.model.dto.ProductRequestDto;
import com.example.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DtoMapper<Product, ProductResponseDto>,
        ModelMapper<Product, ProductRequestDto> {

    @Override
    public ProductResponseDto getDtoFromModel(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setCategory(product.getCategory());
        return productResponseDto;
    }

    @Override
    public Product getModelFromDto(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setCategory(ProductCategory.valueOf(requestDto.getCategory()));
        return product;
    }
}
