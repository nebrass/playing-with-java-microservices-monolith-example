package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Address;
import com.targa.labs.myboutique.web.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
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

    public static Address createFromDto(AddressDto addressDto) {
        if (addressDto != null) {
            return new Address(
                    addressDto.getAddress1(),
                    addressDto.getAddress2(),
                    addressDto.getCity(),
                    addressDto.getPostcode(),
                    addressDto.getCountry()
            );
        }
        return null;
    }
}
