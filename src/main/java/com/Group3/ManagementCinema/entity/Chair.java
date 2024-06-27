package com.Group3.ManagementCinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ghe")
public class Chair {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGhe;
	
	@ManyToOne
	@JoinColumn(name = "idPhong", nullable = false)
	private CinemaRoom idPhong;
	
	@Column(name = "hangGhe")
	private String hangGhe;
	
	@ManyToOne
	@JoinColumn(name = "loaiGhe", nullable = false)
	private ChairPrice loaiGhe;

	@Column(name = "trangThai")
	private int trangThai;
	
	@Column(name = "gheSo")
	private int gheSo;
	
	public long getIdGhe() {
		return idGhe;
	}

	public Chair(long idGhe, CinemaRoom idPhong, String hangGhe, ChairPrice loaiGhe, int trangThai, int gheSo) {
		super();
		this.idGhe = idGhe;
		this.idPhong = idPhong;
		this.hangGhe = hangGhe;
		this.loaiGhe = loaiGhe;
		this.trangThai = trangThai;
		this.gheSo = gheSo;
	}

	public int getGheSo() {
		return gheSo;
	}

	public void setGheSo(int gheSo) {
		this.gheSo = gheSo;
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

	public String getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(String hangGhe) {
		this.hangGhe = hangGhe;
	}

	public ChairPrice getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(ChairPrice loaiGhe) {
		this.loaiGhe = loaiGhe;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public void setIdGhe(long idGhe) {
		this.idGhe = idGhe;
	}

	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

}
