package com.targa.labs.myboutique.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * An Address.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable {

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city")
    private String city;

    //@NotNull
    @Size(max = 10)
    @Column(name = "postcode", length = 10)//, nullable = false)
    private String postcode;

    //@NotNull
    @Size(max = 2)
    @Column(name = "country", length = 2)//, nullable = false)
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(address1, address.address1) &&
                Objects.equals(address2, address.address2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, city, postcode, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
