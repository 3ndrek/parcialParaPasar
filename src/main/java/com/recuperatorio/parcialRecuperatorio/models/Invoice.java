package com.recuperatorio.parcialRecuperatorio.models;


import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceDTO;
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
    private Customer customer;

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

    public void update(InvoiceDTO invoice){
        this.billingAddress = invoice.getBillingAddress();
        this.billingCity = invoice.getBillingCity();
        this.billingCountry = invoice.getBillingCountry();
        this.billingPostalCode = invoice.getBillingPostalCode();
        this.billingState = invoice.getBillingState();
        this.invoiceDate = invoice.getInvoiceDate();
        this.total = invoice.getTotal();
    }
}
