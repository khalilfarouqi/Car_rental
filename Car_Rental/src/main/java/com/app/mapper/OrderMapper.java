package com.app.mapper;

import com.app.dto.OrderDto;
import com.app.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericModelMapper<Order, OrderDto>{
}
