package com.example.model.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String name;
    private boolean premium;
    private int age;
}
