package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class ShippingDetails {
    private final String name;
    private final String address;
    private final String city;
    private final String region;
    private final String postcode;
    private final String country;
    private final boolean freight;

    public ShippingDetails(String name, String address, String city, String region, String postcode, String country, boolean freight) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postcode = postcode;
        this.country = country;
        this.freight = freight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingDetails that = (ShippingDetails) o;
        return freight == that.freight &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(region, that.region) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city, region, postcode, country, freight);
    }
}
