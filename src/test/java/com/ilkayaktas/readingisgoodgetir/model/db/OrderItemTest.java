package com.ilkayaktas.readingisgoodgetir.model.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by ilkayaktas on 10.02.2022 at 17:55.
 */
class OrderItemTest {

    @Test
    void testEquals() {
        OrderItem orderItem1 = OrderItem.builder()
                .id(10L)
                .bookId(11L)
                .orderId(12L)
                .count(12)
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .id(10L)
                .bookId(11L)
                .orderId(12L)
                .count(12)
                .build();

        assertTrue(orderItem1.equals(orderItem2));
        assertFalse(orderItem1.equals(null));

        orderItem1.setId(null);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setId(11L);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setId(10L);
        assertTrue(orderItem1.equals(orderItem2));

        orderItem1.setBookId(null);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setBookId(15L);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setBookId(11L);
        assertTrue(orderItem1.equals(orderItem2));

        orderItem1.setOrderId(null);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setOrderId(15L);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setOrderId(12L);
        assertTrue(orderItem1.equals(orderItem2));

        orderItem1.setCount(null);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setCount(15);
        assertFalse(orderItem1.equals(orderItem2));
        orderItem1.setCount(12);
        assertTrue(orderItem1.equals(orderItem2));


    }
}