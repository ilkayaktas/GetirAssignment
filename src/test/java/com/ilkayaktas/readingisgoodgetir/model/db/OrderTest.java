package com.ilkayaktas.readingisgoodgetir.model.db;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 17:50.
 */
class OrderTest {
    @Test
    void testEquals() {
        Instant now = Instant.now();
        Order order1 = Order.builder()
                .id(10L)
                .orderTime(now)
                .status(1)
                .totalPrice(100.0)
                .customer(Customer.builder().id(10L).build())
                .build();

        Order order2 = Order.builder()
                .id(10L)
                .orderTime(now)
                .status(1)
                .totalPrice(100.0)
                .customer(Customer.builder().id(10L).build())
                .build();

        assertTrue(order1.equals(order2));
        assertFalse(order1.equals(null));

        order1.setId(null);
        assertFalse(order1.equals(order2));
        order1.setId(11L);
        assertFalse(order1.equals(order2));
        order1.setId(10L);
        assertTrue(order1.equals(order2));

        order1.setTotalPrice(null);
        assertNotEquals(order1.getTotalPrice(), order2.getTotalPrice(), "0.1");
        order1.setTotalPrice(11.1);
        assertNotEquals(order1.getTotalPrice(), order2.getTotalPrice(), "0.1");
        order1.setTotalPrice(100.0);
        assertEquals(order1.getTotalPrice(), order2.getTotalPrice(), "0.1");

        order1.setOrderTime(null);
        assertFalse(order1.equals(order2));
        order1.setOrderTime(Instant.MAX);
        assertFalse(order1.equals(order2));
        order1.setOrderTime(now);
        assertTrue(order1.equals(order2));

        order1.setCustomer(null);
        assertFalse(order1.equals(order2));
        order1.setCustomer(Customer.builder().id(11L).build());
        assertFalse(order1.equals(order2));
        order1.setCustomer(Customer.builder().id(10L).build());
        assertTrue(order1.equals(order2));

    }

}