package com.Group3.ManagementCinema.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name = "lichchieu")
public class MovieSchedule {
	@Id
	@Column(name = "idLichChieu")
	private String idLichChieu;
	
	@ManyToOne
    @JoinColumn(name = "phong_chieu_idPhong", nullable = false)
    private CinemaRoom phongChieu;
    
    @ManyToOne
    @JoinColumn(name = "phim_idPhim", nullable = false)
    private Movie phim;
	
	@Column(name = "thoigianBD")
	private Time thoigianBD;
	
	@Column(name = "thoigianKT")
	private Time thoigianKT;
	
	@Column(name = "ngayChieu")
	private Date ngayChieu;

	public String getIdLichChieu() {
		return idLichChieu;
	}

	public void setIdLichChieu(String idLichChieu) {
		this.idLichChieu = idLichChieu;
	}

	public CinemaRoom getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(CinemaRoom phongChieu) {
		this.phongChieu = phongChieu;
	}

	public Movie getPhim() {
		return phim;
	}

	public void setPhim(Movie phim) {
		this.phim = phim;
	}

	public Time getThoigianBD() {
		return thoigianBD;
	}

	public void setThoigianBD(Time thoigianBD) {
		this.thoigianBD = thoigianBD;
	}

	public Time getThoigianKT() {
		return thoigianKT;
	}

	public void setThoigianKT(Time thoigianKT) {
		this.thoigianKT = thoigianKT;
	}

	public Date getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(Date ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public MovieSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieSchedule(String idLichChieu, CinemaRoom phongChieu, Movie phim, Time thoigianBD, Time thoigianKT,
			Date ngayChieu) {
		super();
		this.idLichChieu = idLichChieu;
		this.phongChieu = phongChieu;
		this.phim = phim;
		this.thoigianBD = thoigianBD;
		this.thoigianKT = thoigianKT;
		this.ngayChieu = ngayChieu;
	}
}