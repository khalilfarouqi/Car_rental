package com.app.sevice.impl;

import com.app.dto.OrderDto;
import com.app.sevice.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.app.entity.Order;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceOrderImpl extends BaseServiceImpl<Order, OrderDto> {

}
