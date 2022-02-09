package com.ilkayaktas.readingisgoodgetir.service.order;

import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by ilkayaktas on 6.02.2022 at 00:23.
 */

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getCustomersOrder(Long customerId) {
        Optional<List<Order>> customersOrder = orderRepository.findCustomersOrder(customerId);
        return customersOrder.orElse(null);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersByDate(Instant startDate, Instant endDate) {
        return null;
    }
}
