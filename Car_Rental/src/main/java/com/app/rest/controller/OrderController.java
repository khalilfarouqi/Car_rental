package com.app.rest.controller;

import com.app.dto.OrderDto;
import com.app.entity.Order;
import com.app.rest.api.OrderApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController extends BaseController<Order, OrderDto> implements OrderApi {
    private final OrderService serviceOrder;

    @Override
    public OrderDto getById(@PathVariable("id") Long id) {
        return serviceOrder.getOrderById(id);
    }

    @Override
    public Page<OrderDto> search(String query, Integer page, Integer size, String order, String sort) {
        return serviceOrder.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<OrderDto> getAll() {
        return serviceOrder.getAllOrder();
    }

    @Override
    public IBaseService<Order, OrderDto> getService() {
        return serviceOrder;
    }
}
