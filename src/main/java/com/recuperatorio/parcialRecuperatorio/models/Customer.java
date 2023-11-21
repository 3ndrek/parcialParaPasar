package com.recuperatorio.parcialRecuperatorio.models;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Column(name = "customerid")
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "company")
    private String company;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "supportrepid")
    private String supportRepid;
    public void update(CustomerDTO customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.company = customer.getCompany();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.state = customer.getState();
        this.country = customer.getCountry();
        this.postalCode = customer.getPostalCode();
        this.phone = customer.getPhone();
        this.fax = customer.getFax();
        this.email = customer.getEmail();
        this.supportRepid = customer.getSupportRepid();
    }

}

