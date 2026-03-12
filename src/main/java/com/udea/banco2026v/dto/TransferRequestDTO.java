package com.udea.banco2026v.dto;

public class TransferRequestDTO {
    private String sederAccountNumber;
    private String receiverAccountNumber;
    private double amount;

    public TransferRequestDTO() {
    }

    public TransferRequestDTO(String sederAccountNumber, String receiverAccountNumber, double amount) {
        this.sederAccountNumber = sederAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
    }

    public String getSederAccountNumber() {
        return sederAccountNumber;
    }

    public void setSederAccountNumber(String sederAccountNumber) {
        this.sederAccountNumber = sederAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
