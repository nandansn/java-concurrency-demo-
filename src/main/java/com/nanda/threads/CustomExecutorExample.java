package com.nanda.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class CustomExecutorExample {
  public static void main(String[] args) {

    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    System.out.println("Default parallelism level: " + commonPool.getParallelism());

    // Create a custom ForkJoinPool with 4 threads
    ForkJoinPool customPool = new ForkJoinPool(4);

    // Use the custom pool with CompletableFuture
    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      // Your parallel task here
      System.out.println("Running in custom pool");
    }, customPool);

    // Wait for the task to complete
    future.join();

    // Shutdown the custom pool
    customPool.shutdown();

    System.out.println("payout on process");
  }
}
