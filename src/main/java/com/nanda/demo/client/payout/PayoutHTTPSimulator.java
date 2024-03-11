package com.nanda.demo.client.payout;

import com.nanda.demo.data.Merchant;
import com.nanda.demo.data.PayoutTransactions;
import com.nanda.demo.service.payout.PayoutService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class PayoutHTTPSimulator {

  public static CompletableFuture<Void> generateRequest(ThreadPoolExecutor threadPoolExecutorHigh,
      PayoutService highVolumeService,  Merchant merchantHigh, PayoutTransactions payoutTransactions, double payoutAmount) {



    return CompletableFuture.runAsync(() -> {
      highVolumeService.executePayout(merchantHigh.getMerchantBalance(), payoutTransactions, payoutAmount);
    }, threadPoolExecutorHigh);


  }




}
