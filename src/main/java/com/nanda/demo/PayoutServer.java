package com.nanda.demo;

import com.nanda.demo.client.payout.PayoutHTTPSimulator;
import com.nanda.demo.data.Merchant;
import com.nanda.demo.data.MerchantBalance;
import com.nanda.demo.data.PayoutTransactions;
import com.nanda.demo.service.payout.PayoutService;
import com.nanda.demo.utility.MerchantUtility;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PayoutServer {


  public static void main(String[] args) {

    ThreadPoolExecutor threadPoolExecutorHigh = new ThreadPoolExecutor(20, 30, 5, TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(2));

    ThreadPoolExecutor threadPoolExecutorMedium = new ThreadPoolExecutor(15, 20, 2, TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(2));

    ThreadPoolExecutor threadPoolExecutorLow = new ThreadPoolExecutor(10, 15, 5, TimeUnit.MINUTES,
        new ArrayBlockingQueue<>(2));

    CompletableFuture<?>[] futures = new CompletableFuture[45];

    PayoutTransactions payoutTransactions = new PayoutTransactions();

    PayoutService highVolumeService = new PayoutService();
    Merchant merchantHigh = MerchantUtility.createHighVolume();

    long startTime = System.currentTimeMillis();

    int i = 0;

    for (i = 0; i < 20; i++) {
      futures[i] = PayoutHTTPSimulator.generateRequest(threadPoolExecutorHigh, highVolumeService, merchantHigh,
          payoutTransactions, 500.00);
    }

    PayoutService mediumVolumeService = new PayoutService();
    Merchant merchantMedium = MerchantUtility.createMediumVolume();

    for (; i < 35; i++) {
      futures[i] = PayoutHTTPSimulator.generateRequest(threadPoolExecutorMedium, mediumVolumeService, merchantMedium,
          payoutTransactions, 200.00);
    }

    PayoutService lowVolumeService = new PayoutService();
    Merchant merchantLow = MerchantUtility.createLowVolume();

    for (; i < 45; i++) {
      futures[i] = PayoutHTTPSimulator.generateRequest(threadPoolExecutorLow, lowVolumeService, merchantLow,
          payoutTransactions, 100.00);
    }

    System.out.println(i);

    CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

    // Attach a callback to the combined future
    allOf.thenRun(() -> {
      // Code to be executed after all threads are completed
      payoutTransactions.printTransactions();
      System.out.println(merchantHigh.getMerchantBalance().getBalance());
      System.out.println(merchantMedium.getMerchantBalance().getBalance());
      System.out.println(merchantLow.getMerchantBalance().getBalance());
      long endTime = System.currentTimeMillis();
      long executionTime = endTime - startTime;
      System.out.println("Execution time: " + executionTime + " milliseconds");
    });

    try {
      allOf.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      threadPoolExecutorHigh.shutdown();
      threadPoolExecutorMedium.shutdown();
      threadPoolExecutorLow.shutdown();
    }


  }

}
