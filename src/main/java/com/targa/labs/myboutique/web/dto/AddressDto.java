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
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String country;
}
