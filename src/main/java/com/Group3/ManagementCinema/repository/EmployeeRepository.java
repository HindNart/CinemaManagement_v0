package com.Group3.ManagementCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	List<Employee> findByHoTenNVContaining (String key);
	List<Employee> findByhoTenNVContainingOrDiaChiContainingOrChucVuContaining (String hoten, String diachi, String chucvu);
}
