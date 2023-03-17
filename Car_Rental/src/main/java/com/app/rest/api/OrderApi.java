package com.app.rest.api;

import com.app.dto.OrderDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Order", description = "REST API for Order information")
@RequestMapping("/v1/order")
public interface OrderApi {
    @GetMapping
    List<OrderDto> getAllOrder();

    @GetMapping(value = "/{id}")
    OrderDto getOrderById(@PathVariable Long id);

    @PostMapping
    void saveOrder(@RequestBody OrderDto orderDto);

    @PutMapping(value = "/updateOrder")
    void updateOrder(@RequestBody OrderDto orderDto);

    @DeleteMapping(value = "/{id}")
    void deleteOrder(@PathVariable Long id);
}
