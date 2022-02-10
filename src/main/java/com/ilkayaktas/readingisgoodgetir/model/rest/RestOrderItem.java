package com.ilkayaktas.readingisgoodgetir.model.rest;

import com.ilkayaktas.readingisgoodgetir.model.validator.OrderCountCriteria;
import lombok.*;

/**
 * Created by ilkayaktas on 10.02.2022 at 09:10.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestOrderItem {
    Long itemId;
    @OrderCountCriteria(message = "Order count must be greater than zero!")
    Integer itemCount;
}