package com.nanda.demo.service.payout;

import com.nanda.demo.data.MerchantBalance;
import com.nanda.demo.data.PayoutTransactions;

public class PayoutService {

  Object lock = new Object();

  public void executePayout(MerchantBalance merchantBalance, PayoutTransactions payoutTransactions, double payoutAmount) {
    synchronized (lock) {
      boolean balanceCheck = isBalanceAvailable(merchantBalance, payoutAmount);
      if (balanceCheck) {
        boolean isPayoutProcessed = processPayout(payoutAmount);
        if (isPayoutProcessed) {
          boolean isBalanceUpdated = updateBalance(merchantBalance, payoutAmount);
          if (isBalanceUpdated) {
            boolean isPayoutInserted = insertPayoutTxn(payoutTransactions, payoutAmount);
            if (isPayoutInserted) {
              System.out.println("Payout successfully completed");
            } else {
              System.out.println("recording payout transaction failed");
              System.exit(0);
            }
          } else {
            System.out.println("Balance update failed");
            System.exit(0);
          }
        } else {
          System.out.println("Payout processing failed");
          System.exit(0);
        }
      } else {
        System.out.println("InSufficient Balance");
        System.exit(0);
      }

    }



  }

  public boolean isBalanceAvailable(MerchantBalance merchantBalance, double payoutAmount) {

    double availableBalance = merchantBalance.getBalance();
    System.out.println("check balance:"+availableBalance);
    if (availableBalance >= payoutAmount) {
      return true;
    } else {
      return false;
    }
  }

  public boolean processPayout(double payoutAmount) {
    System.out.println("payout amount processed:"+payoutAmount);
    try {
      Thread.sleep(14000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return true;
  }

  public boolean updateBalance(MerchantBalance merchantBalance, double payoutAmount) {
    merchantBalance.debitAvailableBalance(payoutAmount);
    return true;
  }

  public boolean insertPayoutTxn(PayoutTransactions payoutTransactions, double payoutAmount) {
    return payoutTransactions.addTransaction(payoutAmount);
  }

}
