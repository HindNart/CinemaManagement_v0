package com.Group3.ManagementCinema.entity;

import jakarta.persistence.*;

@Entity
@Table (name="taikhoan")
public class Account {
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
    @Column(name = "diem")
    private int diem;

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

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Account(String email, String username, String password, int diem) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.diem = diem;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
