package com.Group3.ManagementCinema.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table (name="Ve")
public class Ticket {
	@Id
	@Column(name="idVe")
	private String idVe;
	
	@Column(name="idPhim")
	private String idPhim;

	@Column(name="idLichChieu")
	private String idLichChieu;
	
	@Column(name="idKhachHang")
	private String idKhachHang;
	
	@Column(name="idGia")
	private float idGia;
	
	@Column(name="ThoiGianMua")
	private Date ThoiGianMua;

	public String getIdVe() {
		return idVe;
	}

	public void setIdVe(String idVe) {
		this.idVe = idVe;
	}

	public String getIdPhim() {
		return idPhim;
	}

	public void setIdPhim(String idPhim) {
		this.idPhim = idPhim;
	}

	public String getIdLichChieu() {
		return idLichChieu;
	}

	public void setIdLichChieu(String idLichChieu) {
		this.idLichChieu = idLichChieu;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public float getIdGia() {
		return idGia;
	}

	public void setIdGia(float idGia) {
		this.idGia = idGia;
	}

	public Date getThoiGianMua() {
		return ThoiGianMua;
	}

	public void setThoiGianMua(Date thoiGianMua) {
		ThoiGianMua = thoiGianMua;
	}

	public Ticket(String idVe, String idPhim, String idLichChieu, String idKhachHang, float idGia, Date thoiGianMua) {
		super();
		this.idVe = idVe;
		this.idPhim = idPhim;
		this.idLichChieu = idLichChieu;
		this.idKhachHang = idKhachHang;
		this.idGia = idGia;
		ThoiGianMua = thoiGianMua;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
