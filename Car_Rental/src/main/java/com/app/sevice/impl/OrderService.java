package com.app.sevice.impl;

import com.app.dto.OrderDto;
import com.app.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService extends BaseService<Order, OrderDto> {
    @Autowired
    private final OrderRepo orderRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<OrderDto> getAllOrder(){
        List<OrderDto> orderDtoList = new ArrayList<>();
        orderRepository.findAll().forEach(element -> orderDtoList.add(modelMapper.map(element, OrderDto.class)));
        return orderDtoList;
    }

    public OrderDto getOrderById(Long id){
        return modelMapper.map(orderRepository.findById(id), OrderDto.class);
    }

}
