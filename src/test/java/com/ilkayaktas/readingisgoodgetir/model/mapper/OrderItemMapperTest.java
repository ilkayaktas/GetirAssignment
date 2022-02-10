package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.OrderItem;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrderItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ilkayaktas on 10.02.2022 at 19:35.
 */
public class OrderItemMapperTest {

    @Test
    public void toOrderItem() {

        RestOrderItem restOrderItem = new RestOrderItem(12L, 13);

        OrderItem res = OrderItemMapper.INSTANCE.toOrderItem(restOrderItem);

        assertEquals(12L, res.getBookId().longValue());
        assertEquals(13L, res.getCount().longValue());

    }

    @Test
    public void toRestOrderItem() {
        OrderItem orderItem = OrderItem.builder()
                .id(10L)
                .orderId(11L)
                .count(12)
                .bookId(13L)
                .build();

        RestOrderItem res = OrderItemMapper.INSTANCE.toRestOrderItem(orderItem);

        assertEquals(13L, res.getItemId().longValue());
        assertEquals(12L, res.getItemCount().longValue());
    }
}