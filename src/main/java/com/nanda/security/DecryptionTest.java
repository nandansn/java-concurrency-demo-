package com.nanda.security;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DecryptionTest {

  public static void main(String[] args) throws Exception {
    String payload = "oYMnc+4/E6tOpVm5Owhk35scFxVyVDOsyn0hArgqbTrB0sGFL+9xjGU9IG5sk9AgRraE7hrRdgUuKtTkkzJwzylh1lbsUXO30ckNIDzUoPV/WCGE5tUumOGTDCl8tH6Ocifcaf9xN6m9JjgFuvzSKRxk8DpsXPhGcidL52rKQ36xoiE9CB607U1krd4G5Yn0nlfh1kZ0LTmWdxu785yRaQ==";
    String testMerchantApiKey = "a767f0san34fd046eb6d49e60d9c9720";
    String payoutData = decryptThreeDESECB(payload, testMerchantApiKey);
    System.out.println(payoutData);
  }

  public static String decryptThreeDESECB(String src, String key) throws Exception {
     //byte[] bytesrc = new BASE64Decoder().decodeBuffer(src);
    byte[] bytesrc = Base64.getDecoder().decode(src);
    DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
    SecretKey securekey = keyFactory.generateSecret(dks);
    Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, securekey);
    byte[] retByte = cipher.doFinal(bytesrc);
    return new String(retByte);
  }

}
