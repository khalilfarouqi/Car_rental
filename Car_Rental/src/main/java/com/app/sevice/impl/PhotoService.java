package com.app.sevice.impl;

import com.app.dto.PhotoDto;
import com.app.mapper.PhotoMapper;
import com.app.repository.PhotoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.app.entity.Photo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PhotoService extends BaseService<Photo, PhotoDto> {
    private final PhotoRepo photoRepository;
    private final PhotoMapper photoMapper = Mappers.getMapper(PhotoMapper.class);

    public List<PhotoDto> getAllPhoto(){
        return photoMapper.toDto(photoRepository.findAll());
    }

    public PhotoDto getPhotoById(Long id){
        return photoMapper.toDto(photoRepository.findById(id));
    }

}
