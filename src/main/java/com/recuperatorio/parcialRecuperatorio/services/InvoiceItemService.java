package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceItemDTO;
import com.recuperatorio.parcialRecuperatorio.models.Invoice;
import com.recuperatorio.parcialRecuperatorio.models.InvoiceItem;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import com.recuperatorio.parcialRecuperatorio.repositories.IInvoiceItemRepository;
import com.recuperatorio.parcialRecuperatorio.repositories.IInvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemService implements IInvoiceItemService{

    private IInvoiceItemRepository invoiceItemRepository;
    private InvoiceService invoiceService;
    private ITrackService trackService;
    public InvoiceItemService(IInvoiceItemRepository invoiceItemRepository, InvoiceService invoiceService, ITrackService trackService){
        this.invoiceItemRepository = invoiceItemRepository;
        this.invoiceService = invoiceService;
        this.trackService = trackService;
    }
    @Override
    public InvoiceItem create(InvoiceItemDTO InvoiceItem) {
        InvoiceItem nuevoInoiceItem = new InvoiceItem();
        Invoice invoice = invoiceService.findById(InvoiceItem.getInvoiceId());
        Track track = trackService.findById(InvoiceItem.getTrackId());
        nuevoInoiceItem.update(InvoiceItem,invoice, track);
        invoiceItemRepository.save(nuevoInoiceItem);
        return nuevoInoiceItem;
    }

    @Override
    public InvoiceItem update(InvoiceItemDTO InvoiceItem) {
        InvoiceItem invoiceItemOriginal = this.findById(InvoiceItem.getId());
        Invoice invoice = invoiceService.findById(InvoiceItem.getInvoiceId());
        Track track = trackService.findById(InvoiceItem.getTrackId());
        invoiceItemOriginal.update(InvoiceItem, invoice, track);
        invoiceItemRepository.save(invoiceItemOriginal);
        return invoiceItemOriginal;
    }

    @Override
    public InvoiceItem delete(int id) {
        InvoiceItem invoiceItem = this.findById(id);
        invoiceItemRepository.delete(invoiceItem);
        return invoiceItem;
    }

    @Override
    public List<InvoiceItem> getAll() {
        return invoiceItemRepository.findAll();
    }

    @Override
    public InvoiceItem findById(int id) {
        return invoiceItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice no encontrado"));
    }
}
