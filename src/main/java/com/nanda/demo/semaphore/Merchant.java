package com.nanda.demo.semaphore;

import java.security.PrivateKey;

public class Merchant {

  private String name;
  private double balance;


  public Merchant(String name, double balance) {
    this.name = name;
    this.balance = balance;
  }

  public String getName() {
    return this.name;
  }

  public double debitBalance(double amount) {
    return this.balance = this.balance - amount;
  }

}
