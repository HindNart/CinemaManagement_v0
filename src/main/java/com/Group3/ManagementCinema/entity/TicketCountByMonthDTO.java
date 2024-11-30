package com.Group3.ManagementCinema.entity;

public class TicketCountByMonthDTO {
	private int month;
    private long ticketCount;

    // Constructor
    public TicketCountByMonthDTO(int month, long ticketCount) {
        this.month = month;
        this.ticketCount = ticketCount;
    }

    // Getters và Setters
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Month: " + month + ", TicketCount: " + ticketCount;
    }
}
