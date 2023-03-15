package com.app.sevice.impl;

import com.app.dto.UserDto;
import com.app.sevice.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceUserImpl extends BaseServiceImpl<User, UserDto> {

    @Override
    public Page<UserDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        return null;
    }
}
