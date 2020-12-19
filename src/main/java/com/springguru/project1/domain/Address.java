package com.springguru.project1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String addressLine;
    private String city;
    private String state;
    private String zip;

    @OneToOne
    private Publisher publisher;
    
    public Address() {
    }

    public Address(String addressLine, String city, String state, String zip) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    @Override
    public String toString() {
        return "Address [addressLine=" + addressLine + ", city=" + city + ", id=" + id + ", state=" + state + ", zip="
        + zip + "]";
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
    
        Address address = (Address) o;
    
        return address != null ? id.equals(address.id) : address.id == null;
    }
    
}
