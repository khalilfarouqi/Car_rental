package com.app.rest.controller;

import com.app.dto.OrderDto;
import com.app.rest.api.OrderApi;
import com.app.sevice.impl.ServiceOrderImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController implements OrderApi {
    private final ServiceOrderImpl serviceOrder;

    @Override
    public List<OrderDto> getAllOrder() {
        return serviceOrder.getAllOrder();
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return serviceOrder.getOrderById(id);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        serviceOrder.saveOrder(orderDto);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        serviceOrder.updateOrder(orderDto);
    }

    @Override
    public void deleteOrder(Long id) {
        serviceOrder.deleteOrder(id);
    }
}
