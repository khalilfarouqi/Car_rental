package com.app.rest.controller;

import com.app.dto.PhotoDto;
import com.app.rest.api.PhotoApi;
import com.app.sevice.impl.ServicePhotoImpl;
import com.app.sevice.impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PhotoController implements PhotoApi {
    private final ServicePhotoImpl servicePhoto;

    @Override
    public List<PhotoDto> getAllPhoto() {
        return servicePhoto.getAllPhoto();
    }

    @Override
    public PhotoDto getPhotoById(Long id) {
        return servicePhoto.getPhotoById(id);
    }

    @Override
    public void savePhoto(PhotoDto photoDto) {
        servicePhoto.savePhoto(photoDto);
    }

    @Override
    public void updatePhoto(PhotoDto photoDto) {
        servicePhoto.updatePhoto(photoDto);
    }

    @Override
    public void deletePhoto(Long id) {
        servicePhoto.deletePhoto(id);
    }
}
