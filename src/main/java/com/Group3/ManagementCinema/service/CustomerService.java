package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(Long id);
	void deleteCustomerById(Long id);
	Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long countCustomers();
	List<Customer> searchCus(String key);
}
