package com.nanda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestRounding {

  public static void main(String[] args) {

    Double mdr = Double.parseDouble("2.3");
    Double txnAmount = Double.parseDouble("90459.34");

    System.out.println(new BigDecimal(txnAmount * mdr).setScale(2, RoundingMode.HALF_UP).doubleValue());
  }

}
