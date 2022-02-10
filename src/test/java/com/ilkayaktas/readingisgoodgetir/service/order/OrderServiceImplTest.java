package com.ilkayaktas.readingisgoodgetir.service.order;

import com.ilkayaktas.readingisgoodgetir.model.db.Customer;
import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ilkayaktas on 10.02.2022 at 19:10.
 */
public class OrderServiceImplTest {

    @InjectMocks
    OrderServiceImpl orderService;

    @Mock
    OrderRepository orderRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads() {
        assertThat(orderService).isNotNull();
        assertThat(orderRepository).isNotNull();
    }


    @Test
    public void getCustomersOrder() {
    }

    @Test
    public void saveOrder() {
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

        Mockito.when(orderRepository.save(order1)).thenReturn(order2);

        Order res = orderService.saveOrder(order1);

        assertEquals(10L, res.getId().longValue());
        assertEquals(1, res.getStatus().intValue());
        assertEquals(100.0, res.getTotalPrice(), 0.1);
        assertEquals(now.getEpochSecond(), res.getOrderTime().getEpochSecond());
        assertEquals(10L, res.getCustomer().getId().longValue());

    }

    @Test
    public void getOrder() {
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

        Mockito.when(orderRepository.findById(10L)).thenReturn(Optional.of(order2));

        Order res = orderService.getOrder(10L);

        assertEquals(10L, res.getId().longValue());
        assertEquals(1, res.getStatus().intValue());
        assertEquals(100.0, res.getTotalPrice(), 0.1);
        assertEquals(now.getEpochSecond(), res.getOrderTime().getEpochSecond());
        assertEquals(10L, res.getCustomer().getId().longValue());
    }

}