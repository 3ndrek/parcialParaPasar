package com.recuperatorio.parcialRecuperatorio.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoiceid")
    private int invoiceId;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customerId;

    @Column(name="invoicedate")
    private LocalDateTime invoiceDate;

    @Column(name="billingaddress")
    private String billingAddress;

    @Column(name="billingcity")
    private String billingCity;

    @Column(name="billingstate")
    private String billingState;

    @Column(name="billingcountry")
    private String billingCountry;

    @Column(name="billingpostalcode")
    private String billingPostalCode;

    @Column(name="total")
    private double total;
}
