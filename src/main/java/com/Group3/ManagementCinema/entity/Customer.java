package com.Group3.ManagementCinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "khachHang")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idKhach")
	private Long idKhach;
	@Column(name = "tenKhach")
	private String tenKhach;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "diem")
	private int diem;
	@OneToOne(mappedBy = "customer")
	private Account account;

	public Long getIdKhach() {
		return idKhach;
	}

	public void setIdKhach(Long idKhach) {
		this.idKhach = idKhach;
	}

	public String getTenKhach() {
		return tenKhach;
	}

	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long idKhach, String tenKhach, String sdt, int diem, Account account) {
		super();
		this.idKhach = idKhach;
		this.tenKhach = tenKhach;
		this.sdt = sdt;
		this.diem = diem;
		this.account = account;
	}
}
