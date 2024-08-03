package com.nanda.threads.daemon;

public class CodingExeTwo {

  public static void main(String[] args) {
    Thread t1 = new Thread(new InternalService());

    t1.start();
    t1.interrupt();
  }


}

class InternalService implements Runnable {

  @Override
  public void run() {

    while (true) {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        return;
      }
    }

  }
}
