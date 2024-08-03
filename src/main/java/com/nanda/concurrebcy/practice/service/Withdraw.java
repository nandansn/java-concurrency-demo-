package com.nanda.concurrebcy.practice.service;

import com.nanda.concurrebcy.practice.balance.AccountBalance;

public class Withdraw implements Runnable {

  AccountBalance accountBalance;

  double amount;

  public Withdraw(AccountBalance accountBalance, double amount) {
    this.accountBalance = accountBalance;
    this.amount = amount;
  }

  @Override
  public void run() {
    System.out.println("withdraw");
    this.accountBalance.debit(this.amount);
    System.out.println(accountBalance.getBalance());
  }
}
