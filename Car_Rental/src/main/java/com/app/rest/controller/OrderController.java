package com.app.rest.controller;

import com.app.dto.OrderDto;
import com.app.entity.Order;
import com.app.rest.api.OrderApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceOrderImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController extends BaseController<Order, OrderDto> implements OrderApi {

    private final ServiceOrderImpl serviceOrder;
    @Override
    public IBaseService<Order, OrderDto> getService() {
        return serviceOrder;
    }
}
