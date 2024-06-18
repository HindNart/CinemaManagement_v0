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
	
	@OneToMany
	@Column(name = "idPhongChieu")
	private String idPhongChieu;
	
	@OneToMany
	@Column(name = "idPhim")
	private String idPhim;
	
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
		return idPhongChieu;
	}

	public void setIdPhongChieu(String idPhongChieu) {
		this.idPhongChieu = idPhongChieu;
	}

	public String getIdPhim() {
		return idPhim;
	}

	public void setIdPhim(String idPhim) {
		this.idPhim = idPhim;
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

	public MovieSchedule(String idLichChieu, String idPhongChieu, String idPhim, Time thoigianBD, Time thoigianKT,
			Date ngayChieu) {
		super();
		this.idLichChieu = idLichChieu;
		this.idPhongChieu = idPhongChieu;
		this.idPhim = idPhim;
		this.thoigianBD = thoigianBD;
		this.thoigianKT = thoigianKT;
		this.ngayChieu = ngayChieu;
	}

	public MovieSchedule() {
		super();
	}
	
	
}
