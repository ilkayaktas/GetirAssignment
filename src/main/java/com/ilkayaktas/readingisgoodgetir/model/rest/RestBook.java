package com.ilkayaktas.readingisgoodgetir.model.rest;

import com.ilkayaktas.readingisgoodgetir.model.validator.StockCountCriteria;
import lombok.*;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Book name can't be empty!")
    private String name;
    @NotBlank(message = "Book author can't be empty!")
    private String author;
    @StockCountCriteria(message = "Stock count can't be negative value!")
    private Integer stockCount;
}
