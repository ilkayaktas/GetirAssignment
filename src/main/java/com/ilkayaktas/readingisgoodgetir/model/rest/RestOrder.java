package com.ilkayaktas.readingisgoodgetir.model.rest;

import com.ilkayaktas.readingisgoodgetir.model.validator.OrderCountCriteria;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ilkayaktas on 06.02.2022 at 16:28.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestOrder {
    private Long id;
    private Long time;
    @NotNull(message = "Customer id can't be null!")
    private Long customerId;
    @NotNull(message = "Order status can't be null!")
    private Integer status;
    @NotNull(message = "Order list can't be null!")
    @NotEmpty(message = "Order list can't be empty")
    @Valid
    private List<RestOrderItem> items;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
class RestOrderItem {
    Long itemId;
    @OrderCountCriteria(message = "Order count must be greater than zero!")
    Integer itemCount;
}
