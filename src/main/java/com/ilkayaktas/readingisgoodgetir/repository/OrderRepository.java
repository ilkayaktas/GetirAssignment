package com.ilkayaktas.readingisgoodgetir.repository;

import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by ilkayaktas on 6.02.2022 at 23:11.
 */

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select * from order o where o.customer_id = :customerId",
            nativeQuery = true)
    Optional<List<Order>> findCustomersOrder(@Param("customerId") Long customerId);
}
