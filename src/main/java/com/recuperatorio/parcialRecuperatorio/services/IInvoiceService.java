package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.CrearInvoiceDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceDTO;
import com.recuperatorio.parcialRecuperatorio.models.Invoice;

import java.util.List;

public interface IInvoiceService {
    Invoice create(InvoiceDTO invoice);
    Invoice update(InvoiceDTO invoice);
    Invoice delete(int id);
    List<Invoice> getAll();
    Invoice findById(int id);;

    Invoice CrearConDatos(CrearInvoiceDTO invoiceDTO);
}
