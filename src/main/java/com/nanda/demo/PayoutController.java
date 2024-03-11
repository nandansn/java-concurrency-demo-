package com.nanda.demo;

import com.nanda.demo.data.MerchantBalance;
import com.nanda.demo.data.PayoutTransactions;
import com.nanda.demo.service.payout.PayoutService;

public class PayoutController implements Runnable {

  public static MerchantBalance merchantBalance = new MerchantBalance(10000);
  public static PayoutTransactions payoutTransactions = new PayoutTransactions();

  PayoutService payoutService = new PayoutService();

  @Override
  public void run() {

    payoutService.executePayout(merchantBalance, payoutTransactions, 500);
  }
}
