package com.nanda.threads;

import java.util.concurrent.Semaphore;

public class PayoutService {

  static Semaphore semaphore = new Semaphore(1);

  public void processor(String[] args) {
    PayoutProcessing payoutProcessing = new PayoutProcessing();
    //semaphore.acquire();
    //payoutProcessing.processPayout();
    //semaphore.release();
  }

}
