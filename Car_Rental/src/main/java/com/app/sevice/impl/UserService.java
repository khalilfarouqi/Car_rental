package com.app.sevice.impl;

import com.app.dto.UserDto;
import com.app.mapper.UserMapper;
import com.app.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService extends BaseService<User, UserDto> {
    private final UserRepo userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public List<UserDto> getAllUser(){
        return userMapper.toDto(userRepository.findAll());
    }

    public UserDto getUserById(Long id){
        return userMapper.toDto(userRepository.findById(id));
    }

}
