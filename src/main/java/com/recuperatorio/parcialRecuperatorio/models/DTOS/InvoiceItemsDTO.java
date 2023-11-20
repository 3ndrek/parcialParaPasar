package com.recuperatorio.parcialRecuperatorio.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemsDTO {
    private int invoiceId;
    private int trackId;
    private double unitPrice;
    private int quantity;
}
