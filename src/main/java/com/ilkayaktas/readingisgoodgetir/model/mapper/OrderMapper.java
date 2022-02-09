package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by ilkayaktas on 6.02.2022 at 17:56.
 */

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "time", expression = "java(order.getOrderTime().getEpochSecond())")
    @Mapping(target = "customerId", source = "customer.id")
    RestOrder toRestOrder(Order order);

    @Mapping(target = "orderTime", expression = "java(java.time.Instant.ofEpochSecond(restOrder.getTime()))")
    @Mapping(target = "customer", expression = "java(Customer.builder().id(restOrder.getCustomerId()).build())")
    Order toOrder(RestOrder restOrder);
}
