package com.example.model.dto;

import com.example.model.ProductCategory;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private ProductCategory category;
}
