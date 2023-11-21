package com.recuperatorio.parcialRecuperatorio.models;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "invoice_items")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoicelineid")
    private int invoiveLineId;
    @Column(name="unitprice")
    private double unitPrice;
    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "invoiceid")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "trackid")
    private Track track;
    public void update (InvoiceItemDTO invoiceItem, Invoice invoice, Track track){
        this.unitPrice = invoiceItem.getUnitPrice();
        this.quantity = invoiceItem.getQuantity();
        this.invoice = invoice;
        this.track = track;
    }
}
