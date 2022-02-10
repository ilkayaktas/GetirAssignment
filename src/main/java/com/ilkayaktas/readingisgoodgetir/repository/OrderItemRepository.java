package com.ilkayaktas.readingisgoodgetir.repository;

import com.ilkayaktas.readingisgoodgetir.model.db.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ilkayaktas on 10.02.2022 at 09:42.
 */

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
