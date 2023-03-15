package com.app.sevice.impl;

import com.app.dto.OrderDto;
import com.app.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceOrderImpl {
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDto> getAllOrder(){
        return orderRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private OrderDto convertEntityToDto(Order order){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(order, OrderDto.class);
    }

    private Order convertDtoToEntity(OrderDto orderDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(orderDto, Order.class);
    }
}
