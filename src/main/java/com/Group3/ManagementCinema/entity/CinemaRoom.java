package com.Group3.ManagementCinema.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "phongChieu")
public class CinemaRoom {
	@Id
	@Column(name = "idPhong")
	private String idPhong;
	
	@Column(name = "soLuongGhe", nullable = false)
	private int soLuongGhe;
	
	@Column(name = "loaiPhong", nullable = false)
	private String loaiPhong;

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public int getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public CinemaRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CinemaRoom(String idPhong, int soLuongGhe, String loaiPhong) {
		super();
		this.idPhong = idPhong;
		this.soLuongGhe = soLuongGhe;
		this.loaiPhong = loaiPhong;
	}
	
}