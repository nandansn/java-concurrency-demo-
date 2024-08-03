package com.nanda.threads;

import java.util.ArrayList;

public class TestThreads {

  public static void main(String[] args) throws InterruptedException {

    System.out.println(Runtime.getRuntime().availableProcessors());

    while (true) {
      Thread.sleep(2000);
      new ArrayList<>();
      System.out.println(Runtime.getRuntime().totalMemory());
    }
  }

}
