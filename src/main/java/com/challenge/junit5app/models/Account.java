package com.challenge.junit5app.models;

import com.challenge.junit5app.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public class Account {
  private String person;
  private BigDecimal balance;
  private Bank bank;

  public Account(String person, BigDecimal balance) {
    this.person = person;
    this.balance = balance;
  }

  public String getPerson() {
    return person;
  }

  public void setPerson(String person) {
    this.person = person;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public void debit(BigDecimal amount) {
    BigDecimal newBalance = this.balance.subtract(amount);
    if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
      throw new InsufficientFundsException("Insufficient funds");
    }
    this.balance = newBalance;
  }

  public void credit(BigDecimal amount) {
    this.balance = this.balance.add(amount);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Account)) {
      return false;
    }
    Account a = (Account) obj;
    if (this.person == null || this.balance == null) {
      return false;
    }
    return this.person.equals(a.getPerson()) && this.balance.equals(a.getBalance());
  }
}
