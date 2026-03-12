package com.udea.banco2026v.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name= "sender_account_number", nullable=false)
    private String sederAccountNumber;

    @Column(name= "receiver_account_number", nullable=false)
    private String receiverAccountNumber;

    @Column(nullable=false)
    private double amount;

    @Column(nullable=false)
    private LocalDateTime timesTime = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(double amount, long id, String receiverAccountNumber, String sederAccountNumber) {
        this.amount = amount;
        this.id = id;
        this.receiverAccountNumber = receiverAccountNumber;
        this.sederAccountNumber = sederAccountNumber;
    }

    
    

    public Transaction(long id, String sederAccountNumber, String receiverAccountNumber, double amount,
            LocalDateTime timesTime) {
        this.id = id;
        this.sederAccountNumber = sederAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timesTime = timesTime;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSederAccountNumber() {
        return this.sederAccountNumber;
    }

    public void setSederAccountNumber(String sederAccountNumber) {
        this.sederAccountNumber = sederAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return this.receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimesTime() {
        return this.timesTime;
    }

    public void setTimesTime(LocalDateTime timesTime) {
        this.timesTime = timesTime;
    }
}

	