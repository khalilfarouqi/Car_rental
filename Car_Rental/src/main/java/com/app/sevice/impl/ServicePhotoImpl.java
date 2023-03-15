package com.app.sevice.impl;

import com.app.dto.PhotoDto;
import com.app.repository.PhotoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Photo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServicePhotoImpl {
    @Autowired
    private PhotoRepo photoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PhotoDto> getAllPhoto(){
        return photoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private PhotoDto convertEntityToDto(Photo photo){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(photo, PhotoDto.class);
    }

    private Photo convertDtoToEntity(PhotoDto photoDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(photoDto, Photo.class);
    }
}
