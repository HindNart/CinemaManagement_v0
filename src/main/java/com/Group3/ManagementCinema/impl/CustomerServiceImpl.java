package com.Group3.ManagementCinema.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.repository.CustomerRepository;
import com.Group3.ManagementCinema.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public long countCustomers() {
        return customerRepository.count();
    }
	@Override
	public List < Customer > getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		this.customerRepository.save(customer);
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		Optional < Customer > optional = customerRepository.findById(id);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		}
		return customer;
	}
	
	@Override
	public void deleteCustomerById(Long id) {
		this.customerRepository.deleteById(id);
	}
	
	@Override
	public Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Customer> searchCus(String key) {
		// TODO Auto-generated method stub
		return customerRepository.findByTenKhachContaining(key);
	}
}
