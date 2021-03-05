package com.example.model.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;
    private boolean premium;
    private int age;
}
