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
    @JoinColumn(name = "idPhong", nullable = false)
    private CinemaRoom phongChieu;
    
    @ManyToOne
    @JoinColumn(name = "idPhim", nullable = false)
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

	public String getIdPhongChieu() {
		return phongChieu.getId();
	}

	public void setIdPhongChieu(String idPhongChieu) {
		phongChieu.setId(idPhongChieu); 
	}
	
	public String getIdPhim() {
		return phim.getId();
	}

	public void setIdPhim(String idPhim) {
		phim.setId(idPhim);;
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

	public MovieSchedule() {
		super();
	}
	
	
}