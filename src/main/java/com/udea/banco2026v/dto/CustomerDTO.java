package com.udea.banco2026v.dto;

public class CustomerDTO {

    private long id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String balance;

    public CustomerDTO() {
    }

    public CustomerDTO(long id, String firstName, String accountNumber, String lastName, String balance) {
        this.id = id;
        this.firstName = firstName;
        this.accountNumber = accountNumber;
        this.lastName = lastName;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
