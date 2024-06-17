package com.Group3.ManagementCinema.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nhanvien")
public class Employee {
	@Id
	@Column(name = "idNhanVien")
	private String idNhanVien;
	
	@Column(name = "hoTenNV", nullable = false)
	private String hoTenNV;
	
	@Column(name = "ngaySinhNV", nullable = false)
	private Date ngaySinhNV;
	
	@Column(name = "diaChi", nullable = false)
	private String diaChi;
	
	@Column(name = "chucVu", nullable = false)
	private String chucVu;
	
	@Column(name = "luong", nullable = false)
	private float luong;
	
	@Column(name = "caLam", nullable = false)
	private int caLam;
	
	@Column(name = "sdt", nullable = false)
	private String sdt;
}
