package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CrearInvoiceDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceDTO;
import com.recuperatorio.parcialRecuperatorio.models.Invoice;
import com.recuperatorio.parcialRecuperatorio.repositories.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class InvoiceService implements IInvoiceService {
    private IInvoiceRepository invoiceRepository;
    @Autowired
    private ICustomerService serviceCustomers;
    public InvoiceService(IInvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }
    @Override
    public Invoice create(InvoiceDTO invoice) {
        Invoice nuevoInvoice = new Invoice();
        nuevoInvoice.update(invoice);
        invoiceRepository.save(nuevoInvoice);
        return nuevoInvoice;
    }

    @Override
    public Invoice update(InvoiceDTO invoice) {
        Invoice invoiceOriginal = this.findById(invoice.getInvoiceId());
        invoiceOriginal.update(invoice);
        invoiceRepository.save(invoiceOriginal);
        return invoiceOriginal;
    }

    @Override
    public Invoice delete(int id) {
        Invoice invoice = this.findById(id);
        invoiceRepository.delete(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice no encontrado"));
    }

    @Override
    public Invoice CrearConDatos(CrearInvoiceDTO invoiceDTO) {
        Customer customer = serviceCustomers.findById(invoiceDTO.getIdCliente());

        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setCustomer(customer);
        invoice.setTotal(0);





        return null;
    }
}
