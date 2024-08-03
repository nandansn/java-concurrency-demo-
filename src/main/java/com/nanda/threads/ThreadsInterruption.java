package com.nanda.threads;

public class ThreadsInterruption {

  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(() -> {
      new Payment().makePayment();
    }, "fpx");
    t1.start();

    Thread t2 = new Thread(() -> {
      new Payment().makePayment();
    }, "pay labs");
    t2.start();
    // to simulate the interrupted exception
    Thread.sleep(1,10000);

    t2.interrupt();
  }

}

class Payment {
  public void makePayment() {

    if (Thread.currentThread().isInterrupted()) {
      System.out.println(Thread.currentThread().getName() + ":interrupted");
    } else {

      if (Thread.currentThread().getName().equals("fpx")) {
        System.out.println("fpx payment done");
      } else {
        try {

          Thread.sleep(2000);
          System.out.println("paylabs payment done");
        } catch (InterruptedException e) {
          System.out.println("Thread got interrupted");
        }

      }
    }

  }
}
