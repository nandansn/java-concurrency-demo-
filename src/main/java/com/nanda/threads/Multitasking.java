package com.nanda.threads;

public class Multitasking {


  public static void main(String[] args) {

    // create connection
    // read file
    // write into db



    Runnable t2 = new Runnable() {

      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("create connection");
      }
    };



    Runnable t1 = new Runnable() {

      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Reading from file");
      }
    };

   Thread t11 = new Thread(t1);
   t11.start();


   Thread t22 = new Thread(t2);
   t22.start();
  }


}
