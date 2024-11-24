package com.Group3.ManagementCinema.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "phim")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPhim")
	private Long idPhim;

	@Column(name = "tenPhim", nullable = false)
	private String tenPhim;

	@Column(name = "theLoai", nullable = false)
	private String theLoai;

	@Column(name = "daoDien", nullable = false)
	private String daoDien;

	@Column(name = "dienVien", nullable = false)
	private String dienVien;

	@Column(name = "thoiLuong", nullable = false)
	private int thoiLuong;

	@Column(name = "moTa", nullable = false)
	private String moTa;

	@Column(name = "ngayPH", nullable = false)
	private Date ngayPH;

	@Column(name = "linkPoster", nullable = false)
	private String linkPoster;

	@Column(name = "trangthai")
	private boolean trangthai;
	@Transient
	private double averageRating;

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public Long getIdPhim() {
		return idPhim;
	}

	public void setIdPhim(Long idPhim) {
		this.idPhim = idPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getDaoDien() {
		return daoDien;
	}

	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}

	public String getDienVien() {
		return dienVien;
	}

	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayPH() {
		return ngayPH;
	}

	public void setNgayPH(Date ngayPH) {
		this.ngayPH = ngayPH;
	}

	public String getLinkPoster() {
		return linkPoster;
	}

	public void setLinkPoster(String linkPoster) {
		this.linkPoster = linkPoster;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long idPhim, String tenPhim, String theLoai, String daoDien, String dienVien, int thoiLuong,
			String moTa, Date ngayPH, String linkPoster) {
		super();
		this.idPhim = idPhim;
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
		this.daoDien = daoDien;
		this.dienVien = dienVien;
		this.thoiLuong = thoiLuong;
		this.moTa = moTa;
		this.ngayPH = ngayPH;
		this.linkPoster = linkPoster;
	}

	public Movie(Long idPhim, String tenPhim, String theLoai, String daoDien, String dienVien, int thoiLuong,
			String moTa, Date ngayPH, String linkPoster, double averageRating) {
		super();
		this.idPhim = idPhim;
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
		this.daoDien = daoDien;
		this.dienVien = dienVien;
		this.thoiLuong = thoiLuong;
		this.moTa = moTa;
		this.ngayPH = ngayPH;
		this.linkPoster = linkPoster;
		this.averageRating = averageRating;
	}
}
