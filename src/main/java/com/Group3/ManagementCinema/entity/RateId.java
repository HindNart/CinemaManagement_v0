package com.Group3.ManagementCinema.entity;

import java.util.Objects;

public class RateId {
	private String maTaikhoan;
	
    private String maPhim;
    
	public RateId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RateId(String maTaikhoan, String maPhim) {
		super();
		this.maTaikhoan = maTaikhoan;
		this.maPhim = maPhim;
	}

	public String getMaTaikhoan() {
		return maTaikhoan;
	}

	public void setMaTaikhoan(String maTaikhoan) {
		this.maTaikhoan = maTaikhoan;
	}

	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhim, maTaikhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RateId other = (RateId) obj;
		return Objects.equals(maPhim, other.maPhim) && Objects.equals(maTaikhoan, other.maTaikhoan);
	}
}
