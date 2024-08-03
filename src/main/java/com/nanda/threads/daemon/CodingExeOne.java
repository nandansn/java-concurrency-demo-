package com.nanda.threads.daemon;

import java.io.IOException;

public class CodingExeOne {

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      while (true) {
        try {
          char c = (char) System.in.read();
          if (c == 'q') {
            return;
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });

    t1.start();
  }

}
