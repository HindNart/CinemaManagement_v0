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
import jakarta.persistence.OneToMany;
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
	
	@ManyToMany
    @JoinTable(name = "ticket_chair",joinColumns = @JoinColumn(name = "ticket_id"),inverseJoinColumns = @JoinColumn(name = "chair_id"))
    private List<Chair> ghe;

	public long getIdVe() {
		return idVe;
	}

	public void setIdVe(long idVe) {
		this.idVe = idVe;
	}

	public MovieSchedule getLichChieu() {
		return lichChieu;
	}

	public List<Chair> getGhe() {
		return ghe;
	}

	public void setGhe(List<Chair> ghe) {
		this.ghe = ghe;
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

	public Ticket(long idVe, MovieSchedule lichChieu, Account taiKhoan, float gia, Date thoigianMua, List<Chair> ghe) {
		super();
		this.idVe = idVe;
		this.lichChieu = lichChieu;
		this.taiKhoan = taiKhoan;
		this.gia = gia;
		this.thoigianMua = thoigianMua;
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

}
