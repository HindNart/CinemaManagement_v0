package com.Group3.ManagementCinema.entity;

import java.util.List;

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

	@OneToMany(mappedBy = "idPhong", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Chair> chairs;
	
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
	

	public List<Chair> getChairs() {
		return chairs;
	}

	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}

	public CinemaRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CinemaRoom(String idPhong, int soLuongGhe, String loaiPhong, List<Chair> chairs) {
		super();
		this.idPhong = idPhong;
		this.soLuongGhe = soLuongGhe;
		this.loaiPhong = loaiPhong;
		this.chairs = chairs;
	}
	
}