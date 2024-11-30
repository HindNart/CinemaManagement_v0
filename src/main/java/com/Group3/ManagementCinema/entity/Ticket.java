package com.Group3.ManagementCinema.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ve")
public class Ticket {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVe;
	
	@ManyToOne
    @JoinColumn(name = "idLichChieu", nullable = false)
    private MovieSchedule idLichChieu;
	
	@ManyToOne
	@JoinColumn(name = "tai_khoan_email", nullable = false)
	private Account taiKhoan;
	
	@ManyToOne
    @JoinColumn(name = "idGhe", nullable = true)
    private Chair idGhe;
	
	@Column(name = "thoigianMua")
	private Date thoigianMua;

	public long getIdVe() {
		return idVe;
	}

	public void setIdVe(Long idVe) {
		this.idVe = idVe;
	}

	public MovieSchedule getIdLichChieu() {
		return idLichChieu;
	}

	public Chair getGhe() {
		return idGhe;
	}

	public void setGhe(Chair ghe) {
		this.idGhe = ghe;
	}

	public void setIdLichChieu(MovieSchedule idLichChieu) {
		this.idLichChieu = idLichChieu;
	}

	public Account getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(Account taiKhoan) {
		this.taiKhoan = taiKhoan;
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
	
	public Ticket(long idVe, MovieSchedule idLichChieu, Account taiKhoan, Date thoigianMua, Chair ghe) {
		super();
		this.idVe = idVe;
		this.idLichChieu = idLichChieu;
		this.taiKhoan = taiKhoan;
		this.thoigianMua = thoigianMua;
		this.idGhe = ghe;
	}
}
