package com.app.rest.controller;

import com.app.dto.PhotoDto;
import com.app.entity.Photo;
import com.app.rest.api.PhotoApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServicePhotoImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PhotoController extends BaseController<Photo, PhotoDto> implements PhotoApi {

    private final ServicePhotoImpl servicePhoto;
    @Override
    public IBaseService<Photo, PhotoDto> getService() {
        return servicePhoto;
    }
}
