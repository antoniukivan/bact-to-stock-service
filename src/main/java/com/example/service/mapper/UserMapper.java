package com.example.service.mapper;

import com.example.model.User;
import com.example.model.dto.UserRequestDto;
import com.example.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<User, UserResponseDto>,
        ModelMapper<User, UserRequestDto> {

    @Override
    public User getModelFromDto(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPremium(requestDto.isPremium());
        user.setAge(requestDto.getAge());
        return user;
    }

    @Override
    public UserResponseDto getDtoFromModel(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setPremium(user.isPremium());
        return userResponseDto;
    }
}
