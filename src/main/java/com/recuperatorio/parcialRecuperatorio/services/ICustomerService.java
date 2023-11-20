package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ICustomerService {
    Customer create(CustomerDTO customer);
    Customer update(CustomerDTO customer);
    Customer delete(CustomerDTO customer);
    Customer delete(Long id);
    List<Customer> getAll();
    Optional<Customer> findById(Long id);

}
