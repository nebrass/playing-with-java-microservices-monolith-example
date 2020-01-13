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
public class ReviewDto {
    private Long id;
    private String title;
    private String description;
    private Long rating;
}
