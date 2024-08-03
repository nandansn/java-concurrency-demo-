package com.nanda.concurrebcy.practice.service;

import com.nanda.concurrebcy.practice.balance.AccountBalance;

public class Deposit implements Runnable {

  AccountBalance accountBalance;

  double amount;

  public Deposit(AccountBalance accountBalance, double amount) {
    this.accountBalance = accountBalance;
    this.amount = amount;
  }

  @Override
  public void run() {
    System.out.println("deposit");
    this.accountBalance.credit(this.amount);
    System.out.println(accountBalance.getBalance());
  }

}
