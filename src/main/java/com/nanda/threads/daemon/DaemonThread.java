package com.nanda.threads.daemon;

import java.math.BigInteger;

public class DaemonThread {

  public static void main(String[] args) {

    Thread t = new Thread(() -> {
      new ExternalPaymentService().isRiskyPayment();
    });
    t.setDaemon(true);
    t.start();

    // if the interrupt is not handled. then we can go for set daemon. for external service we don't have the control.
    // we called external service and we wait for long time, then if we need to interrupt then we can set the our
    // calling thread as daemon like above and when we call interrupt this will stop the calling thread.
    t.interrupt();

  }

}

class ExternalPaymentService {
  BigInteger result  = BigInteger.ONE;
  public boolean isRiskyPayment() {
    for (BigInteger i = BigInteger.ZERO; i.compareTo(new BigInteger("100000000")) != 0; i.add(BigInteger.ONE)) {
        result = result.multiply(new BigInteger("20000"));
    }
    return false;
  }
}
