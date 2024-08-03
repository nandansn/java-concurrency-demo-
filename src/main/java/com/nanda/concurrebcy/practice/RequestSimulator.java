package com.nanda.concurrebcy.practice;

import com.nanda.concurrebcy.practice.balance.AccountBalance;
import com.nanda.concurrebcy.practice.service.Deposit;
import com.nanda.concurrebcy.practice.service.Withdraw;

public class RequestSimulator {



  public static void main(String[] args) throws InterruptedException {

    while (true) {

      AccountBalance accountBalance = new AccountBalance(0.00);
      Thread[] withDrawThreads = new Thread[10];
      for (int i = 0; i < 10; i++) {
        withDrawThreads[i] = new Thread(new Withdraw(accountBalance, 100));
        withDrawThreads[i].start();
      }

      Thread[] depositThreads = new Thread[12];
      for (int i = 0; i < 12; i++) {
        depositThreads[i] = new Thread(new Deposit(accountBalance, 100));
        depositThreads[i].start();
      }

      for (Thread thread : depositThreads) {
        thread.join();
      }

      for (Thread thread : withDrawThreads) {
        thread.join();
      }

      System.out.println("final balance:" + accountBalance.getBalance());

      if ( accountBalance.getBalance() != 200.00) {
        System.exit(0);
      }

    }

  }

}
