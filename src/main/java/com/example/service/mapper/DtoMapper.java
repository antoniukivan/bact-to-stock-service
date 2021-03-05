package com.example.service.mapper;

public interface DtoMapper<M, D> {
    D getDtoFromModel(M entity);
}
