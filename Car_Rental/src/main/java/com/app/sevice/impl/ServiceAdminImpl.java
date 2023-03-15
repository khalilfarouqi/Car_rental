package com.app.sevice.impl;

import com.app.dto.AdminDto;
import com.app.entity.Admin;
import com.app.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceAdminImpl {
    @Autowired
    private AdminRepo adminRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<AdminDto> getAllAdmin(){
        return adminRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private AdminDto convertEntityToDto(Admin admin){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(admin, AdminDto.class);
    }

    private Admin convertDtoToEntity(AdminDto adminDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(adminDto, Admin.class);
    }
}
