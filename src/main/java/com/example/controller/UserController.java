package com.example.controller;

import com.example.model.Product;
import com.example.model.User;
import com.example.model.dto.ProductRequestDto;
import com.example.model.dto.UserRequestDto;
import com.example.model.dto.UserResponseDto;
import com.example.service.BackToStockService;
import com.example.service.UserService;
import com.example.service.mapper.ProductMapper;
import com.example.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;
    private final ProductMapper productMapper;
    private final BackToStockService backToStockService;

    @PostMapping
    public void save(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.getModelFromDto(userRequestDto);
        userService.save(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.getDtoFromModel(user);
    }

    @PostMapping("/{id}/subscribe")
    public void subscribe(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
        User user = userService.findById(id);
        Product product = productMapper.getModelFromDto(productRequestDto);
        backToStockService.subscribe(product, user);
    }

    @PostMapping("/{id}/unsubscribe")
    public void unsubscribe(@PathVariable Long id,
                            @RequestBody ProductRequestDto productRequestDto) {
        User user = userService.findById(id);
        Product product = productMapper.getModelFromDto(productRequestDto);
        backToStockService.unsubscribe(product, user);
    }
}
