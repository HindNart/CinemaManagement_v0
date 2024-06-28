package com.Group3.ManagementCinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "giaGhe")
public class ChairPrice {
	@Id 
	@Column(name="loaiGhe")
	private String loaiGhe;

	@Column(name = "gia")
	private float gia;

	public String getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(String id) {
		this.loaiGhe = id;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public ChairPrice(String id, float gia) {
		super();
		this.loaiGhe = id;
		this.gia = gia;
	}

	public ChairPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}