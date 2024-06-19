package com.Group3.ManagementCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Group3.ManagementCinema.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
