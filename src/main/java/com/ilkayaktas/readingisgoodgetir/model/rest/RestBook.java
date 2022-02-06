package com.ilkayaktas.readingisgoodgetir.model.rest;

import lombok.*;

/**
 * Created by ilkayaktas on 6.02.2022 at 17:51.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestBook {
    private Long id;
    private String name;
    private String author;
    private Integer stockCount;
}
