package com.targa.labs.myboutique.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Nebrass Lamouchi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    private Integer salesCounter;
    private Set<ReviewDto> reviews;
    private Long categoryId;
}
