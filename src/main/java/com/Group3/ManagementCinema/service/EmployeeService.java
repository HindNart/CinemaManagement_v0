package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Employee;
import com.Group3.ManagementCinema.entity.Movie;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee Employee);
	Employee getEmployeeById(Long id);
	void deleteEmployeeById(Long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long countEmployee();
	List<Employee> searchEmp(String key);
	Employee getEmployeeByName(String name);
}
