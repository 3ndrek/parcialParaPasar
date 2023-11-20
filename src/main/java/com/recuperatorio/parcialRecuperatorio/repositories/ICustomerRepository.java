package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
