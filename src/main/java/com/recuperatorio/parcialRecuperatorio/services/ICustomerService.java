package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface ICustomerService {
    Customer create(CustomerDTO customer);
    Customer update(CustomerDTO customer);
    Customer delete(int id);
    List<Customer> getAll();
    Customer findById(int id);
    void validarCustomer(CustomerDTO customer);

}
