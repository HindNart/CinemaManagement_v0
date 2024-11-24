package com.Group3.ManagementCinema.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@Column(name = "gheSo")
	private int gheSo;

	@Column(name = "giaGhe")
	private int giaGhe;
	
	@Column(name = "loaiGhe")
	private String loaiGhe;
	
	@Column(name = "trangThai")
	private int trangThai;
	
	@OneToMany(mappedBy = "idGhe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> tickets;
	
	public long getIdGhe() {
		return idGhe;
	}

	public void setIdGhe(long idGhe) {
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

	public int getGheSo() {
		return gheSo;
	}

	public void setGheSo(int soGhe) {
		this.gheSo = soGhe;
	}

	public int getGiaGhe() {
		return giaGhe;
	}

	public void setGiaGhe(int giaGhe) {
		this.giaGhe = giaGhe;
	}
	
	
	public String getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(String loaiGhe) {
		this.loaiGhe = loaiGhe;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chair(long idGhe, CinemaRoom idPhong, String hangGhe, int gheSo, int giaGhe, List<Ticket> tickets, String loaiGhe, int trangThai) {
		super();
		this.idGhe = idGhe;
		this.idPhong = idPhong;
		this.hangGhe = hangGhe;
		this.gheSo = gheSo;
		this.giaGhe = giaGhe;
		this.tickets = tickets;
		this.loaiGhe = loaiGhe;
		this.trangThai = trangThai;
	}

}
