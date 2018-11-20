package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Address;
import com.targa.labs.myboutique.web.dto.AddressDto;


public class AddressService {

    public static AddressDto mapToDto(Address address) {
        if (address != null) {
            return new AddressDto(
                    address.getAddress1(),
                    address.getAddress2(),
                    address.getCity(),
                    address.getPostcode(),
                    address.getCountry()
            );
        }
        return null;
    }
}
