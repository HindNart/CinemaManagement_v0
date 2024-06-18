package com.Group3.ManagementCinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ghe")
public class Chair {
	@Id
	@Column(name = "idGhe")
	private int idGhe;
	
	@OneToMany
	@Column(name = "idPhongChieu")
	private String idPhongChieu;
	
	@Column(name = "hangGhe")
	private int hangGhe;
	
	@Column(name = "loaiGhe")
	private String loaiGhe;
	
	@Column(name = "trangThai")
	private int trangThai;
	
	@Column(name = "gia")
	private float gia;
}
