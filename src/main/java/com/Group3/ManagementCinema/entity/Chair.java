package com.Group3.ManagementCinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ghe")
public class Chair {
	@Id
	@Column(name = "idGhe")
	private int idGhe;
	
	@OneToMany
	@JoinColumn(name = "idPhong", nullable = false)
	private CinemaRoom idPhong;
	
	@Column(name = "hangGhe")
	private int hangGhe;
	
	@Column(name = "loaiGhe")
	private String loaiGhe;

	@Column(name = "trangThai")
	private int trangThai;
	
	@Column(name = "gia")
	private float gia;
	
	public int getIdGhe() {
		return idGhe;
	}

	public void setIdGhe(int idGhe) {
		this.idGhe = idGhe;
	}

	public CinemaRoom getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(CinemaRoom idPhong) {
		this.idPhong = idPhong;
	}

	public int getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(int hangGhe) {
		this.hangGhe = hangGhe;
	}

	public String getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(String loaiGhe) {
		this.loaiGhe = loaiGhe;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

}
