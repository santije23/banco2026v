package com.udea.banco2026v.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    private long id;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private double amount;
    private LocalDateTime timesTime;

    public TransactionDTO() {
    }

    public TransactionDTO(long id, String senderAccountNumber, String receiverAccountNumber, double amount, LocalDateTime timesTime) {
        this.id = id;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timesTime = timesTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
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

    public LocalDateTime getTimesTime() {
        return timesTime;
    }

    public void setTimesTime(LocalDateTime timesTime) {
        this.timesTime = timesTime;
    }
}
