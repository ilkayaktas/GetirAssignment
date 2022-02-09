package com.ilkayaktas.readingisgoodgetir.model.rest;

import lombok.*;

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
    private List<Integer> items;
}
