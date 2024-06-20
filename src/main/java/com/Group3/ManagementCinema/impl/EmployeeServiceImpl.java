package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Employee;
import com.Group3.ManagementCinema.repository.EmployeeRepository;
import com.Group3.ManagementCinema.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	public long countEmployee() {
        return EmployeeRepository.count();
    }
	@Override
	public List < Employee > getAllEmployees() {
		return EmployeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee Employee) {
		this.EmployeeRepository.save(Employee);
	}
	
	@Override
	public Employee getEmployeeById(String id) {
		Optional < Employee > optional = EmployeeRepository.findById(id);
		Employee Employee = null;
		if (optional.isPresent()) {
			Employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return Employee;
	}
	
	@Override
	public void deleteEmployeeById(String id) {
		this.EmployeeRepository.deleteById(id);
	}
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}
}
