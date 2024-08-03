package com.nanda.demo.semaphore;

import java.util.ArrayList;
import java.util.List;

public class MerchantsRepository {

  List<Merchant> merchantList = new ArrayList<>();

  {
    merchantList.add(new Merchant("nanda",20000.00))  ;
    merchantList.add(new Merchant("kumar",10000.00))  ;
    merchantList.add(new Merchant("raj",2000.00))  ;
  }

  public Merchant findMerchant(String name) {
    return merchantList.stream().filter(m -> m.getName().equals(name)).findAny().get();
  }

}
