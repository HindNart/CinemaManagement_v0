package com.Group3.ManagementCinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="danhGia")
@IdClass(RateId.class)
public class Rate {
	@Id
	@ManyToOne
	@JoinColumn(name = "tai_khoan_email")
	private Account taiKhoan;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "phim_idPhim")
    private Movie phim;
	
	@Column(name = "noiDung")
	private String noiDung;

	public Account getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(Account taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Movie getPhim() {
		return phim;
	}

	public void setPhim(Movie phim) {
		this.phim = phim;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Rate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rate(Account taiKhoan, Movie phim, String noiDung) {
		super();
		this.taiKhoan = taiKhoan;
		this.phim = phim;
		this.noiDung = noiDung;
	}
}
