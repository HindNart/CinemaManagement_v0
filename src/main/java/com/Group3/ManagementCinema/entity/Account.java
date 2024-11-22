package com.Group3.ManagementCinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")
public class Account {
	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role")
	private String role;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "employee_id", nullable = true)
	private Employee employee;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Account(String email, String username, String password, String role, Customer customer, Employee employee) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.customer = customer;
		this.employee = employee;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
