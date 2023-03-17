package com.app.rest.api;

import com.app.dto.PhotoDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Photo", description = "REST API for Photo information")
@RequestMapping("/v1/photo")
public interface PhotoApi {
    @GetMapping
    List<PhotoDto> getAllPhoto();

    @GetMapping(value = "/{id}")
    PhotoDto getPhotoById(@PathVariable Long id);

    @PostMapping
    void savePhoto(@RequestBody PhotoDto photoDto);

    @PutMapping(value = "/updatePhoto")
    void updatePhoto(@RequestBody PhotoDto photoDto);

    @DeleteMapping(value = "/{id}")
    void deletePhoto(@PathVariable Long id);
}
