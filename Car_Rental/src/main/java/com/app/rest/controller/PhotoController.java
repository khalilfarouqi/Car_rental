package com.app.rest.controller;

import com.app.dto.PhotoDto;
import com.app.entity.Photo;
import com.app.rest.api.PhotoApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PhotoController extends BaseController<Photo, PhotoDto> implements PhotoApi {
    private final PhotoService servicePhoto;

    @Override
    public PhotoDto getById(@PathVariable("id") Long id) {
        return servicePhoto.getPhotoById(id);
    }

    @Override
    public Page<PhotoDto> search(String query, Integer page, Integer size, String order, String sort) {
        return servicePhoto.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<PhotoDto> getAll() {
        return servicePhoto.getAllPhoto();
    }

    @Override
    public IBaseService<Photo, PhotoDto> getService() {
        return servicePhoto;
    }
}
