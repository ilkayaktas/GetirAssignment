package com.ilkayaktas.readingisgoodgetir.service.order;

import com.ilkayaktas.readingisgoodgetir.model.db.Order;

import java.time.Instant;
import java.util.List;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:41.
 */

public interface OrderService {
    List<Order> getCustomersOrder(Long customerId);

    Order createOrder(Order order);

    Order getOrder(Long orderId);

    List<Order> getOrdersByDate(Instant startDate, Instant endDate);
}
