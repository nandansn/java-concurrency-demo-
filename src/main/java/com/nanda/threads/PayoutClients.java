package com.nanda.threads;

import com.nanda.demo.service.payout.PayoutService;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PayoutClients {

  public static void main(String[] args) {

    PayoutProcessing processor = new PayoutProcessing();

    // Simulating multiple payment requests
//    Runnable task = () -> processor.processPayout();

    ExecutorService balancePool = Executors.newFixedThreadPool(2);
    ExecutorService curlecPool = Executors.newFixedThreadPool(8);
    ExecutorService storagePool = Executors.newFixedThreadPool(8);
    ExecutorService ipnPool = Executors.newFixedThreadPool(12);

//    for (int i = 0; i < 30; i++) {
//
//      CompletableFuture.runAsync(() -> processor.processPayout(), executor);
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }

    for (int i = 0; i < 100; i++) {

      int amount = 10;
      int finalI = i;
      CompletableFuture.supplyAsync(() -> processor.checkBalance(amount, finalI),balancePool)
           .thenApplyAsync(balanceAvailable -> processor.curlecService(finalI),curlecPool)
           .thenApplyAsync(payoutCompleted -> processor.persistData(finalI),storagePool)
           .thenApplyAsync(dataSrored -> processor.sendIPN(finalI), ipnPool);
    }

//    curlecPool.shutdown();
//    storagePool.shutdown();
//    ipnPool.shutdown();

   while (true) {

   }

  }

}
