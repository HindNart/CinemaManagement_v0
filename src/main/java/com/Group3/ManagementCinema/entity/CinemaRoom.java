package com.Group3.ManagementCinema.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phongChieu")
public class CinemaRoom {
	@Id
	@Column(name = "idPhong")
	private String id;
	
	@Column(name = "soLuongGhe", nullable = false)
	private int soLuongGhe;
	
	@Column(name = "loaiPhong", nullable = false)
	private String loaiPhong;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public CinemaRoom(String id, int soLuongGhe, String loaiPhong) {
		super();
		this.id = id;
		this.soLuongGhe = soLuongGhe;
		this.loaiPhong = loaiPhong;
	}
}
