package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import com.recuperatorio.parcialRecuperatorio.repositories.ICustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{
    private ICustomerRepository customerRepository;
    public CustomerServiceImpl(ICustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public void validarCustomer(CustomerDTO customer){
        if (customer.getFirstName().length()>40){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 40 caracteres");
        }
        if (customer.getLastName().length()>20){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del apellido es mayor a 20 caracteres");
        }
        if (customer.getCompany().length()>80){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud de la compañia es mayor a 80 caracteres");
        }
        if (customer.getAddress().length()>70){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud de la dirección es mayor a 70 caracteres");
        }
        if (customer.getCity().length()>40){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud de la ciudad es mayor a 40 caracteres");
        }
        if (customer.getState().length()>40){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del estado es mayor a 40 caracteres");
        }
        if (customer.getCountry().length()>40){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del país es mayor a 40 caracteres");
        }
        if (customer.getPostalCode().length()>10){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del código postal es mayor a 10 caracteres");
        }
        if (customer.getPhone().length()>24){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del teléfono es mayor a 24 caracteres");
        }
        if (customer.getFax().length()>24){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del fax es mayor a 24 caracteres");
        }
        if (customer.getEmail().length()>60){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del email es mayor a 60 caracteres");
        }

    }
    @Override
    public Customer create(CustomerDTO customer) {
        Customer nuevoCustomer = new Customer();
        validarCustomer(customer);
        nuevoCustomer.update(customer);
        customerRepository.save(nuevoCustomer);
        return nuevoCustomer;
    }

    @Override
    public Customer update(CustomerDTO customer) {
        this.validarCustomer(customer);

        Customer customerOriginal = this.findById(customer.getId());
        customerOriginal.update(customer);
        customerRepository.save(customerOriginal);
        return customerOriginal;
    }


    @Override
    public Customer delete(int id) {
        Customer customer = this.findById(id);
        this.customerRepository.delete(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer no encontrado"));
        return customer;
    }
}
