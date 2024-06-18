package com.Group3.ManagementCinema.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nhanvien")
public class Employee {
    @Id
    @Column(name = "idNhanVien")
    private String idNhanVien;

    @Column(name = "hoTenNV", nullable = false)
    private String hoTenNV;

    @Column(name = "ngaySinhNV", nullable = false)
    private Date ngaySinhNV;

    @Column(name = "diaChi", nullable = false)
    private String diaChi;

    @Column(name = "chucVu", nullable = false)
    private String chucVu;

    @Column(name = "luong", nullable = false)
    private float luong;

    @Column(name = "caLam", nullable = false)
    private int caLam;

    @Column(name = "sdt", nullable = false)
    private String sdt;

    // Getters and Setters
    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public Date getNgaySinhNV() {
        return ngaySinhNV;
    }

    public void setNgaySinhNV(Date ngaySinhNV) {
        this.ngaySinhNV = ngaySinhNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getCaLam() {
        return caLam;
    }

    public void setCaLam(int caLam) {
        this.caLam = caLam;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
	public Employee() {
		super();
	}

	public Employee(String idNhanVien, String hoTenNV, Date ngaySinhNV, String diaChi, String chucVu, float luong,
			int caLam, String sdt) {
		super();
		this.idNhanVien = idNhanVien;
		this.hoTenNV = hoTenNV;
		this.ngaySinhNV = ngaySinhNV;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.luong = luong;
		this.caLam = caLam;
		this.sdt = sdt;
	}
    
}
