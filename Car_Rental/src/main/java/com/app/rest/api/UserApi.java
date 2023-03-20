package com.app.rest.api;

import com.app.dto.UserDto;
import com.app.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "User", description = "REST API for User information")
@RequestMapping("/v1/user")
public interface UserApi extends BaseApi<User, UserDto> {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UserDto saveUser(@RequestBody UserDto userDto);

    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    UserDto updateUser(@RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id);

    @GetMapping
    List<UserDto> getAllUser();
}
