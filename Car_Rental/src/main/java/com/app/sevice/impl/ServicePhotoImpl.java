package com.app.sevice.impl;

import com.app.dto.PhotoDto;
import com.app.repository.PhotoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.entity.Photo;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServicePhotoImpl {
    private final PhotoRepo photoRepository;
    private final ModelMapper modelMapper;

    public List<PhotoDto> getAllPhoto(){
        List<PhotoDto> photoDtoList = new ArrayList<>();
        photoRepository.findAll().forEach(element -> photoDtoList.add(modelMapper.map(element, PhotoDto.class)));
        return photoDtoList;
    }

    public PhotoDto getPhotoById(Long id){
        return modelMapper.map(photoRepository.findById(id), PhotoDto.class);
    }

    public void savePhoto(PhotoDto photoDto){
        photoRepository.save(modelMapper.map(photoDto, Photo.class));
    }

    public void updatePhoto(PhotoDto photoDto){
        photoRepository.save(modelMapper.map(photoDto, Photo.class));
    }

    public void deletePhoto(Long id){
        photoRepository.deleteById(id);
    }
}
