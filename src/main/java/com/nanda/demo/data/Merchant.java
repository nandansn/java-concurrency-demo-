package com.nanda.demo.data;


public class Merchant {

  private String name;
  private String volume;

  private MerchantBalance merchantBalance;

  public Merchant(String name, String volume, MerchantBalance merchantBalance) {
    this.name = name;
    this.volume = volume;
    this.merchantBalance = merchantBalance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public MerchantBalance getMerchantBalance() {
    return merchantBalance;
  }

  public void setMerchantBalance(MerchantBalance merchantBalance) {
    this.merchantBalance = merchantBalance;
  }
}
