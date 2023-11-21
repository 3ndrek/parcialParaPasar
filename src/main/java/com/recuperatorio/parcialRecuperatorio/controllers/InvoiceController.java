package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceDTO;
import com.recuperatorio.parcialRecuperatorio.models.Invoice;
import com.recuperatorio.parcialRecuperatorio.services.IInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Invoice")
@RequiredArgsConstructor
public class InvoiceController {
    private IInvoiceService invoiceService;
    public InvoiceController(IInvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Invoice> invoices;
        try{
            invoices = invoiceService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las facturas" + ex.getMessage());
        }
        return ResponseEntity.ok(invoices);

    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody InvoiceDTO invoiceDTO){
        Invoice invoice;
        try{
            invoice = invoiceService.create(invoiceDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al crear la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoice);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable  int id){
        Invoice invoice;
        try{
            invoice = invoiceService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoice);
    }
    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody InvoiceDTO invoiceDTO){
        Invoice invoice;
        try{
            invoice = invoiceService.update(invoiceDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al actualizar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoice);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable  int id){
        try{
            invoiceService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al eliminar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok("Factura eliminada");
    }
}
