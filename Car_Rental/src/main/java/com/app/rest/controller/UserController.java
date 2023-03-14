package com.app.rest.controller;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.rest.api.UserApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController extends BaseController<User, UserDto> implements UserApi {

    private final ServiceUserImpl serviceUser;
    @Override
    public IBaseService<User, UserDto> getService() {
        return serviceUser;
    }
}
