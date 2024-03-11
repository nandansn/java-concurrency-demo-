package com.nanda.demo.data;

import java.util.ArrayList;
import java.util.List;

public class PayoutTransactions {

  private List<Double> payouts;

  public PayoutTransactions() {
    this.payouts = new ArrayList<>(45);
  }

  public boolean addTransaction(double payoutAmount) {
    this.payouts.add(payoutAmount);
    return true;
  }

  public void printTransactions() {

    payouts.forEach(System.out::println);
    System.out.println("total transactions:"+payouts.size());
  }

}
