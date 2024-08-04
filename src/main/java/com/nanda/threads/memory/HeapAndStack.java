package com.nanda.threads.memory;

public class HeapAndStack {

  String name;

  public static void main(String[] args) {
    int a = 10;
    HeapAndStack hs = new HeapAndStack();
        hs.display();
    System.out.println("jill");
  }

  public void display() {
    name = "nanda";

    int x = 10;

    System.out.println(name);
  }

}
