package com.app.sevice.impl;

import com.app.dto.OrderDto;
import com.app.mapper.OrderMapper;
import com.app.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import com.app.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService extends BaseService<Order, OrderDto> {
    private final OrderRepo orderRepository;
    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    public List<OrderDto> getAllOrder(){
        return orderMapper.toDto(orderRepository.findAll());
    }

    public OrderDto getOrderById(Long id){
        return orderMapper.toDto(orderRepository.findById(id));
    }

}
