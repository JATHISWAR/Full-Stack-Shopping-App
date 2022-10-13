package com.jathiswar.ecommerceapp.dao;

import com.jathiswar.ecommerceapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
