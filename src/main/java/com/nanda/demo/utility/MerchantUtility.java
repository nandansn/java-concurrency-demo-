package com.nanda.demo.utility;

import com.nanda.demo.data.Merchant;
import com.nanda.demo.data.MerchantBalance;

public class MerchantUtility {

  public static Merchant createHighVolume() {
    Merchant merchant;
    merchant = new Merchant("XPAY","HIGH", new MerchantBalance(100000));
    return merchant;
  }

  public static Merchant createMediumVolume() {
    Merchant merchant;
    merchant = new Merchant("VALETAX","MEDIUM", new MerchantBalance(50000));
    return merchant;
  }

  public static Merchant createLowVolume() {
    Merchant merchant;
    merchant = new Merchant("Product2U","LOW", new MerchantBalance(10000));
    return merchant;
  }



}
