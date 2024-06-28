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
	
	@ManyToMany
    @JoinTable(
        name = "ticket_chair",
        joinColumns = @JoinColumn(name = "ticket_id"),
        inverseJoinColumns = @JoinColumn(name = "chair_id")
    )
    private List<Chair> ghe;
	
	@Column(name = "thoigianMua")
	private Date thoigianMua;

	public long getIdVe() {
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

	public List<Chair> getGhe() {
		return ghe;
	}

	public void setGhe(List<Chair> ghe) {
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

	public Ticket(Long idVe, MovieSchedule lichChieu, Account taiKhoan, List<Chair> ghe, Date thoigianMua) {
		super();
		this.idVe = idVe;
		this.lichChieu = lichChieu;
		this.taiKhoan = taiKhoan;
		this.ghe = ghe;
		this.thoigianMua = thoigianMua;
	}

}
