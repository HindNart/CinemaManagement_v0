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
@Table(name="danhGia")
public class Rate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDanhGia;
	
	@ManyToOne
	@JoinColumn(name = "tai_khoan_email")
	private Account taiKhoan;
	
    @ManyToOne
    @JoinColumn(name = "idPhim")
    private Movie phim;
    
    @Column(name = "diem")
    private int diem;
    
	@Column(name = "binhLuan")
	private String binhLuan;

	public Long getId() {
		return idDanhGia;
	}

	public void setId(Long id) {
		this.idDanhGia = id;
	}

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

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public Rate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rate(Long idDanhGia, Account taiKhoan, Movie phim, int diem, String binhLuan) {
		super();
		this.idDanhGia = idDanhGia;
		this.taiKhoan = taiKhoan;
		this.phim = phim;
		this.diem = diem;
		this.binhLuan = binhLuan;
	}

}
