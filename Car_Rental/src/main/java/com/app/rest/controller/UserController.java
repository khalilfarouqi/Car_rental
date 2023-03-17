package com.app.rest.controller;

import com.app.dto.UserDto;
import com.app.rest.api.UserApi;
import com.app.sevice.impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {
    private final ServiceUserImpl serviceUser;

    @Override
    public List<UserDto> getAllUser() {
        return serviceUser.getAllUser();
    }

    @Override
    public UserDto getUserById(Long id) {
        return serviceUser.getUserById(id);
    }

    @Override
    public void saveUser(UserDto userDto) {
        serviceUser.saveUser(userDto);
    }

    @Override
    public void updateUser(UserDto userDto) {
        serviceUser.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long id) {
        serviceUser.deleteUser(id);
    }
}
