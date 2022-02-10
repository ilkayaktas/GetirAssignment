package com.ilkayaktas.readingisgoodgetir.repository;

import com.ilkayaktas.readingisgoodgetir.model.db.MonthlyOrderStatistics;
import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by ilkayaktas on 6.02.2022 at 23:11.
 */

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select * from orders o where o.customer_id = :customerId",
            nativeQuery = true)
    Optional<List<Order>> findCustomersOrder(@Param("customerId") Long customerId);

    @Query(value = "select * from orders o where o.order_time > :start and o.order_time < :end",
            nativeQuery = true)
    Optional<List<Order>> findOrderByDate(@Param("start") Instant start, @Param("end") Instant end);

    @Query(value = "select MONTHNAME(o.order_time) as Month,\n" +
            "       sum(distinct o.totalPrice) as TotalPurchaseAmount,\n" +
            "       count(distinct o2.orderId) as TotalOrderCount,\n" +
            "        sum(o2.count) as TotalBookCount\n" +
            "    from orders o\n" +
            "    inner join orderitem o2 on o.id = o2.orderId\n" +
            "    where o.customer_id = :customerId\n" +
            "    group by MONTHNAME(o.order_time)",
    nativeQuery = true)
    List<MonthlyOrderStatistics> getMonthlyStatistics(@Param("customerId") Long customerId);
}
