package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private ICustomerService customerService;
    @Test
    void validarCustomer() {
        CustomerDTO nuevoCustomer = new CustomerDTO();
        // first name con más de 40 caracteres
        nuevoCustomer.setFirstName("1234567890123456789012345678901234567890123");
        nuevoCustomer.setLastName("Apellido de prueba");
        nuevoCustomer.setCompany("Compañia de prueba");
        nuevoCustomer.setAddress("Direccion de prueba");
        nuevoCustomer.setCity("Ciudad de prueba");
        nuevoCustomer.setState("Estado de prueba");
        nuevoCustomer.setCountry("Pais de prueba");
        nuevoCustomer.setPostalCode("Codigo postal de prueba");
        nuevoCustomer.setPhone("Telefono de prueba");
        nuevoCustomer.setFax("Fax de prueba");
        nuevoCustomer.setEmail("Email de prueba");
        assertThrows(Exception.class, () -> {
            customerService.validarCustomer(nuevoCustomer);
        });
    }

    @Test
    void create() {
        CustomerDTO nuevoCustomer = new CustomerDTO();
        nuevoCustomer.setFirstName("Nombre de prueba");
        nuevoCustomer.setLastName("Apellido de prueba");
        nuevoCustomer.setCompany("Compañia de prueba");
        nuevoCustomer.setAddress("Direccion de prueba");
        nuevoCustomer.setCity("Ciudad de prueba");
        nuevoCustomer.setState("Estado de prueba");
        nuevoCustomer.setCountry("Pais de prueba");
        nuevoCustomer.setPostalCode("Codigo postal de prueba");
        nuevoCustomer.setPhone("Telefono de prueba");
        nuevoCustomer.setFax("Fax de prueba");
        nuevoCustomer.setEmail("Email de prueba");
        Customer customerCreado =  customerService.create(nuevoCustomer);
        // me fijo si existe el nuevo customer
        Customer customerParaTestear = customerService.findById(customerCreado.getCustomerId());
        // lo borramos de la base de datos
        customerService.delete(customerParaTestear.getCustomerId());
        assertEquals(customerParaTestear, customerCreado);
    }

    @Test
    void update() {
        CustomerDTO nuevoCustomer = new CustomerDTO();
        nuevoCustomer.setFirstName("Nombre de prueba");
        nuevoCustomer.setLastName("Apellido de prueba");
        nuevoCustomer.setCompany("Compañia de prueba");
        nuevoCustomer.setAddress("Direccion de prueba");
        nuevoCustomer.setCity("Ciudad de prueba");
        nuevoCustomer.setState("Estado de prueba");
        nuevoCustomer.setCountry("Pais de prueba");
        nuevoCustomer.setPostalCode("Codigo postal de prueba");
        nuevoCustomer.setPhone("Telefono de prueba");
        nuevoCustomer.setFax("Fax de prueba");
        nuevoCustomer.setEmail("Email de prueba");
        Customer customerCreado =  customerService.create(nuevoCustomer);
        // cambio el nombre
        nuevoCustomer.setId(customerCreado.getCustomerId());
        nuevoCustomer.setFirstName("Nombre de prueba 2");
        // lo actualizo
        Customer customerParaTestear = customerService.update(nuevoCustomer);
        // lo borro de la base de datos
        customerService.delete(customerParaTestear.getCustomerId());
        // me fijo si el nombre cambio
        assertNotEquals(customerParaTestear.getFirstName(), customerCreado.getFirstName());
    }

    @Test
    void delete() {
        CustomerDTO nuevoCustomer = new CustomerDTO();
        nuevoCustomer.setFirstName("Nombre de prueba");
        nuevoCustomer.setLastName("Apellido de prueba");
        nuevoCustomer.setCompany("Compañia de prueba");
        nuevoCustomer.setAddress("Direccion de prueba");
        nuevoCustomer.setCity("Ciudad de prueba");
        nuevoCustomer.setState("Estado de prueba");
        nuevoCustomer.setCountry("Pais de prueba");
        nuevoCustomer.setPostalCode("Codigo postal de prueba");
        nuevoCustomer.setPhone("Telefono de prueba");
        nuevoCustomer.setFax("Fax de prueba");
        nuevoCustomer.setEmail("Email de prueba");
        Customer customerCreado =  customerService.create(nuevoCustomer);
        // me fijo si existe el nuevo customer
        Customer customerParaTestear = customerService.findById(customerCreado.getCustomerId());
        // lo borramos de la base de datos
        customerService.delete(customerParaTestear.getCustomerId());
        // me fijo si existe el nuevo customer de nuevo
        assertThrows(IllegalArgumentException.class, () -> {
            customerService.findById(customerParaTestear.getCustomerId());
        });
    }



    @Test
    void findById() {
        CustomerDTO nuevoCustomer = new CustomerDTO();
        nuevoCustomer.setFirstName("Nombre de prueba");
        nuevoCustomer.setLastName("Apellido de prueba");
        nuevoCustomer.setCompany("Compañia de prueba");
        nuevoCustomer.setAddress("Direccion de prueba");
        nuevoCustomer.setCity("Ciudad de prueba");
        nuevoCustomer.setState("Estado de prueba");
        nuevoCustomer.setCountry("Pais de prueba");
        nuevoCustomer.setPostalCode("Codigo postal de prueba");
        nuevoCustomer.setPhone("Telefono de prueba");
        nuevoCustomer.setFax("Fax de prueba");
        nuevoCustomer.setEmail("Email de prueba");
        Customer customerCreado =  customerService.create(nuevoCustomer);
        // me fijo si existe el nuevo customer
        Customer customerParaTestear = customerService.findById(customerCreado.getCustomerId());
        // lo borramos de la base de datos
        customerService.delete(customerParaTestear.getCustomerId());
        // me fijo si existe el nuevo customer de nuevo
        assertThrows(IllegalArgumentException.class, () -> {
            customerService.findById(customerParaTestear.getCustomerId());
        });
    }
}