package com.app.rest.api;

import com.app.dto.UserDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "User", description = "REST API for User information")
@RequestMapping("/v1/user")
public interface UserApi {
    @GetMapping
    List<UserDto> getAllUser();

    @GetMapping(value = "/{id}")
    UserDto getUserById(@PathVariable Long id);

    @PostMapping
    void saveUser(@RequestBody UserDto userDto);

    @PutMapping(value = "/updateUser")
    void updateUser(@RequestBody UserDto userDto);

    @DeleteMapping(value = "/{id}")
    void deleteUser(@PathVariable Long id);
}
