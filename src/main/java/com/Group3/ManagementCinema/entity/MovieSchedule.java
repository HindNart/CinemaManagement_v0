package com.Group3.ManagementCinema.entity;

import java.sql.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "lichchieu")
public class MovieSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLichChieu")
	private Long idLichChieu;
	
	@ManyToOne
    @JoinColumn(name = "phong_chieu_idPhong", nullable = false)
    private CinemaRoom phongChieu;
    
    @ManyToOne
    @JoinColumn(name = "phim_idPhim", nullable = false)
    private Movie phim;
	
	@Column(name = "thoigianBD")
	private String thoigianBD;
	
	@Column(name = "thoigianKT")
	private String thoigianKT;
	
	@Column(name = "ngayChieu")
	private Date ngayChieu;

	public Long getIdLichChieu() {
		return idLichChieu;
	}

	public void setIdLichChieu(Long idLichChieu) {
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

	public String getThoigianBD() {
		return thoigianBD;
	}

	public void setThoigianBD(String thoigianBD) {
		this.thoigianBD = thoigianBD;
	}

	public String getThoigianKT() {
		return thoigianKT;
	}

	public void setThoigianKT(String thoigianKT) {
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

	public MovieSchedule(Long idLichChieu, CinemaRoom phongChieu, Movie phim, String thoigianBD, String thoigianKT,
			java.util.Date ngayChieu) {
		super();
		this.idLichChieu = idLichChieu;
		this.phongChieu = phongChieu;
		this.phim = phim;
		this.thoigianBD = thoigianBD;
		this.thoigianKT = thoigianKT;
		this.ngayChieu = (Date) ngayChieu;
	}
}
