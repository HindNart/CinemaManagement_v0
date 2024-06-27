package com.Group3.ManagementCinema.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ve")
public class Ticket {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVe;
	
	@ManyToOne
    @JoinColumn(name = "lich_chieu_idLichChieu", nullable = false)
    private MovieSchedule lichChieu;
	
	@ManyToOne
	@JoinColumn(name = "tai_khoan_email", nullable = false)
	private Account taiKhoan;
	
	@Column(name = "gia")
	private float gia;
	
	@Column(name = "thoigianMua")
	private Date thoigianMua;

	public long getIdVe() {
		return idVe;
	}

	public void setIdVe(long idVe) {
		this.idVe = idVe;
	}

	public MovieSchedule getLichChieu() {
		return lichChieu;
	}

	public void setLichChieu(MovieSchedule lichChieu) {
		this.lichChieu = lichChieu;
	}

	public Account getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(Account taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Date getThoigianMua() {
		return thoigianMua;
	}

	public void setThoigianMua(Date thoigianMua) {
		this.thoigianMua = thoigianMua;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(long idVe, MovieSchedule lichChieu, Account taiKhoan, float gia, Date thoigianMua) {
		super();
		this.idVe = idVe;
		this.lichChieu = lichChieu;
		this.taiKhoan = taiKhoan;
		this.gia = gia;
		this.thoigianMua = thoigianMua;
	}
}
