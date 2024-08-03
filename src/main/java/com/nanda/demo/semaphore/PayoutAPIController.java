package com.nanda.demo.semaphore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class PayoutAPIController {

  private static final ConcurrentHashMap<String, Semaphore> merchantLocks = new ConcurrentHashMap<>();

  private static final Semaphore specialMerchantLock = new Semaphore(1);

  public void makePayout(String merchantKey, double payoutAmount, String payoutType) {

    Semaphore lock;

      if (merchantKey.isEmpty()) {
        lock = specialMerchantLock;
      } else {
        merchantLocks.put(merchantKey, new Semaphore(1));
        lock = merchantLocks.get(merchantKey);
      }

      try {
        lock.acquire();
        Merchant merchant = new MerchantsRepository().findMerchant(merchantKey);


      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.release();
      }
  }

}
