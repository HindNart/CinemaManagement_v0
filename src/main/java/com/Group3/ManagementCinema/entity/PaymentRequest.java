package com.Group3.ManagementCinema.entity;

public class PaymentRequest {
    private double amount;
    private String orderId;

    // Getters và Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}