package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.model.db.OrderItem;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrder;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestOrderItem;
import org.junit.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 19:39.
 */
public class OrderMapperTest {

    @Test
    public void toRestOrder() {
        Instant now = Instant.now();
        Order order1 = Order.builder()
                .id(10L)
                .orderTime(now)
                .status(1)
                .totalPrice(100.0)
                .customer(Customer.builder().id(10L).build())
                .orderItems(List.of(OrderItem.builder().id(17L).build()))
                .build();

        RestOrder res = OrderMapper.INSTANCE.toRestOrder(order1);

        assertEquals(10L, res.getId().longValue());
        assertEquals(1, res.getStatus().intValue());
        assertEquals(100.0, res.getTotalPrice(), 0.1);
        assertEquals(10L, res.getCustomerId().longValue());
        assertEquals(now.getEpochSecond(), res.getTime().longValue());
    }

    @Test
    public void toOrder() {
        Instant now = Instant.now();
        RestOrder order1 = RestOrder.builder()
                .id(10L)
                .time(now.getEpochSecond())
                .status(1)
                .totalPrice(100.0)
                .customerId(10L)
                .items(List.of(RestOrderItem.builder().itemId(17L).build()))
                .build();

        Order res = OrderMapper.INSTANCE.toOrder(order1);
        assertEquals(10L, res.getId().longValue());
        assertEquals(1, res.getStatus().intValue());
        assertEquals(100.0, res.getTotalPrice(), 0.1);
        assertEquals(now.getEpochSecond(), res.getOrderTime().getEpochSecond());
        assertEquals(10L, res.getCustomer().getId().longValue());
    }
}