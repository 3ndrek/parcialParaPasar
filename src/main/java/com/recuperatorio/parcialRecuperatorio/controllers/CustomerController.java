package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import com.recuperatorio.parcialRecuperatorio.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Customer> customers;
        try{
            customers = customerService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las playlist" + ex.getMessage());
        }
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Customer customer;
        try{
            customer = customerService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(customer);
    }
    @PostMapping()
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO){
    Customer customer;
        try{
            customer = customerService.create(customerDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(customer);
}
    @PutMapping()
    public ResponseEntity<Object> updateCustomer( @RequestBody CustomerDTO customerDTO){
        Customer customer;
        try{
            customer = customerService.update( customerDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(customer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int id){
        Customer customer;
        try{
            customer = customerService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok("Se eliminó el customer con id: " + id);
    }

}
