package com.app.rest.api;

import com.app.dto.AdminDto;
import com.app.entity.Admin;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Admin", description = "REST API for Admin information")
@RequestMapping("/v1/admin")
public interface AdminApi extends BaseApi<Admin, AdminDto> {

}
