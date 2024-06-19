package com.Group3.ManagementCinema.entity;

import jakarta.persistence.*;

@Entity
@Table  
public class Customer {
	@Id
	@Column(name = "idKhach")
	private String idKhach;
	@Column(name = "tenKhach")
	private String tenKhach;
	@Column(name = "sdt")
	private String sdt;
	@Column(name= "diem")
	private int diem;
	public String getIdKhach() {
		return idKhach;
	}
	public void setIdKhach(String idKhach) {
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
	public Customer(String idKhach, String tenKhach, String sdt, int diem) {
		super();
		this.idKhach = idKhach;
		this.tenKhach = tenKhach;
		this.sdt = sdt;
		this.diem = diem;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
}
