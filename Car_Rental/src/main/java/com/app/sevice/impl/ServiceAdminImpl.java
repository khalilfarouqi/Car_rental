package com.app.sevice.impl;

import com.app.dto.AdminDto;
import com.app.entity.Admin;
import com.app.sevice.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceAdminImpl extends BaseServiceImpl<Admin, AdminDto> {

}