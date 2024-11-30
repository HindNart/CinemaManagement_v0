package com.Group3.ManagementCinema.entity;

import java.math.BigDecimal;

public class TicketPriceOnMonthDTO {
	private int month;
	private BigDecimal totalPrice;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public TicketPriceOnMonthDTO(int month, BigDecimal totalPrice) {
		super();
		this.month = month;
		this.totalPrice = totalPrice;
	}
}
