package com.app.rest.api;

import com.app.dto.OrderDto;
import com.app.entity.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Tag(name = "Order", description = "REST API for Order information")
@RequestMapping("/v1/order")
public interface OrderApi extends BaseApi<Order, OrderDto> {

}
