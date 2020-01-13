package com.targa.labs.myboutique.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nebrass Lamouchi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private Long customerId;
    private String status;
}
