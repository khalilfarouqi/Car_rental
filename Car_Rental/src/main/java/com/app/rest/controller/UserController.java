package com.app.rest.controller;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.rest.api.UserApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.BaseService;
import com.app.sevice.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController extends BaseController<User, UserDto> implements UserApi {
    private final UserService userService;

    @Override
    public IBaseService getService() {
        return (IBaseService) userService;
    }

    @Override
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @Override
    public Page<UserDto> search(String query, Integer page, Integer size, String order, String sort) {
        return userService.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }
}
