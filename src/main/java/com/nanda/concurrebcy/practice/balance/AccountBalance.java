package com.nanda.concurrebcy.practice.balance;

public class AccountBalance {

  private double balance;

  public AccountBalance(double balance) {
    this.balance = balance;
  }

  public synchronized void credit(double amount) {
    this.balance = this.balance + amount;
  }

  public  synchronized void debit(double amount) {
    this.balance = this.balance - amount;
  }

  public double getBalance() {
    return this.balance;
  }

}
