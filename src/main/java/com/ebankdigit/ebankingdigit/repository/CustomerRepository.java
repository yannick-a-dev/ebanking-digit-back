package com.ebankdigit.ebankingdigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebankdigit.ebankingdigit.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
