package com.nanda.threads;

import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class PayoutProcessing {

  static int balance = 1000;
  static int requestCount = 0;

  ReentrantLock lock = new ReentrantLock(true);

//  public void processPayout() {
//    System.out.println("check the balance");
//    this.checkBalance();
//    System.out.println("curlec processing the payout");
//    this.curlecService();
//    System.out.println("persist the payout");
//    this.persistData();
//  }

  public boolean checkBalance(int amount, int i) {



    lock.lock();
    requestCount = requestCount + 1;
    try {
      System.out.println("before:"+balance);
      if (balance >= amount) {
        Thread.sleep(100);
        balance = balance - amount;
        System.out.println("after:"+balance);
        System.out.println("check balance for:"+i);
        return true;
      }
      System.out.println("balance time:"+ LocalTime.now());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      lock.unlock();
    }
    return false;
  }

  public boolean curlecService(int i) {
    try {
      Thread.sleep(10000);
      System.out.println("curlec time:"+ LocalTime.now());
      System.out.println("curlec call for:"+i);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  public boolean persistData(int i) {
    try {

      Thread.sleep(200);
      System.out.println("stored balance:"+balance);
      System.out.println("stored balance update for:"+i);
      System.out.println("storage time:"+ LocalTime.now());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  public boolean sendIPN(int i) {
    try {
      Thread.sleep(20);
      System.out.println("notification sent for:"+i);
      System.out.println("ipn time:"+ LocalTime.now());

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  public int getBalance() {
    return balance;
  }

}
