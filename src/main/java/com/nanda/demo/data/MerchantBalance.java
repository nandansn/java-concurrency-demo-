package com.nanda.demo.data;

public class MerchantBalance {

  private double availableBalance;

  public MerchantBalance(double amount) {
    this.availableBalance = amount;
  }

  public void creditAvailableBalance(double amount) {
    this.availableBalance = this.availableBalance + amount;
  }

  public void debitAvailableBalance(double amount) {
    this.availableBalance = this.availableBalance - amount;
  }

  public double getBalance() {
    return this.availableBalance;
  }

}
