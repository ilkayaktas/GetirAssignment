package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.OrderItem;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by ilkayaktas on 10.02.2022 at 09:08.
 */

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(target = "bookId", source = "itemId")
    @Mapping(target = "count", source = "itemCount")
    OrderItem toOrderItem(RestOrderItem restOrderItem);

    @Mapping(source = "bookId", target = "itemId")
    @Mapping(source = "count", target = "itemCount")
    RestOrderItem toRestOrderItem(OrderItem orderItem);
}
