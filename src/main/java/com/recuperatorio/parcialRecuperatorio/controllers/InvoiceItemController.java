package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceItemDTO;
import com.recuperatorio.parcialRecuperatorio.models.InvoiceItem;
import com.recuperatorio.parcialRecuperatorio.services.IInvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-item")
@RequiredArgsConstructor
public class InvoiceItemController {
    private IInvoiceItemService invoiceItemService;
    public InvoiceItemController(IInvoiceItemService invoiceItemService){
        this.invoiceItemService = invoiceItemService;
    }
    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<InvoiceItem> invoiceItems;
        try{
            invoiceItems = invoiceItemService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las facturas" + ex.getMessage());
        }
        return ResponseEntity.ok(invoiceItems);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        InvoiceItem invoiceItem;
        try{
            invoiceItem = invoiceItemService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoiceItem);
    }
    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody InvoiceItemDTO invoiceItem){
        InvoiceItem invoiceItem1;
        try{
            invoiceItem1 = invoiceItemService.create(invoiceItem);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al crear la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoiceItem1);
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody InvoiceItemDTO invoiceItem){
        InvoiceItem invoiceItem1;
        try{
            invoiceItem1 = invoiceItemService.update(invoiceItem);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al actualizar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok(invoiceItem1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        InvoiceItem invoiceItem;
        try{
            invoiceItem = invoiceItemService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al eliminar la factura" + ex.getMessage());
        }
        return ResponseEntity.ok("Se eliminó el Invoice Item con id: " + id);
    }

}
