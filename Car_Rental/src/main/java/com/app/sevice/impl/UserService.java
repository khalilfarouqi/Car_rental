package com.app.sevice.impl;

import com.app.dto.UserDto;
import com.app.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService extends BaseService<User, UserDto> {
    @Autowired
    private final UserRepo userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<UserDto> getAllUser(){
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach(element -> userDtoList.add(modelMapper.map(element, UserDto.class)));
        return userDtoList;
    }

    public UserDto getUserById(Long id){
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }

}
