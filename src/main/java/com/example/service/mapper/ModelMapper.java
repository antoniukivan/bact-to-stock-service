package com.example.service.mapper;

public interface ModelMapper<M, D> {
    M getModelFromDto(D requestDto);
}
