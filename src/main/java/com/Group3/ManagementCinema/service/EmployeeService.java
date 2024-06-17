package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee Employee);
	Employee getEmployeeById(String id);
	void deleteEmployeeById(String id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
