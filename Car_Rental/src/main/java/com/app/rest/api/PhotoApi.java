package com.app.rest.api;

import com.app.dto.PhotoDto;
import com.app.entity.Photo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Photo", description = "REST API for Photo information")
@RequestMapping("/v1/photo")
public interface PhotoApi {

}
