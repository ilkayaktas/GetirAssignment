package com.ilkayaktas.readingisgoodgetir.model.rest;

import lombok.*;

/**
 * Created by ilkayaktas on 6.02.2022 at 20:41.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestStatistics {
    private String month;
    private Integer orderCount;
    private Integer bookCount;
    private Double totalPrice;
}
