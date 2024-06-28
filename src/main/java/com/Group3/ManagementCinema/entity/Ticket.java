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
    private Long idVe;
	
	@ManyToOne
    @JoinColumn(name = "lich_chieu_idLichChieu", nullable = false)
    private MovieSchedule lichChieu;
	
	@ManyToOne
	@JoinColumn(name = "tai_khoan_email", nullable = false)
	private Account taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "ghe_idGhe", nullable = false)
	private Chair ghe;
	
	@Column(name = "thoigianMua")
	private Date thoigianMua;

	public Long getIdVe() {
		return idVe;
	}

	public void setIdVe(Long idVe) {
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

	public Chair getGhe() {
		return ghe;
	}

	public void setGhe(Chair ghe) {
		this.ghe = ghe;
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

	public Ticket(Long idVe, MovieSchedule lichChieu, Account taiKhoan, Chair ghe, Date thoigianMua) {
		super();
		this.idVe = idVe;
		this.lichChieu = lichChieu;
		this.taiKhoan = taiKhoan;
		this.ghe = ghe;
		this.thoigianMua = thoigianMua;
	}

}
