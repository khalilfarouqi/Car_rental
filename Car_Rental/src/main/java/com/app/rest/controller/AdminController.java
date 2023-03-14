package com.app.rest.controller;

import com.app.dto.AdminDto;
import com.app.entity.Admin;
import com.app.rest.api.AdminApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceAdminImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AdminController extends BaseController<Admin, AdminDto> implements AdminApi {

    private final ServiceAdminImpl serviceAdmin;
    @Override
    public IBaseService<Admin, AdminDto> getService() {
        return serviceAdmin;
    }
}
