package com.ilkayaktas.readingisgoodgetir.model.rest;

import lombok.*;

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
    private Long customerId;
    private Integer status;
}
