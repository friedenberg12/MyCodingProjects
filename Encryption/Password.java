/*
 *  Password Encryption
 *
 *  (c)2014 by David Friedenberg
 *
 *  This code was written by David Friedenberg
 *  for public use. Have fun!
*/

import java.util.Arrays;
import java.util.Random;
public class Password {

  private Random randgen = new Random();
  private String userPass;
  private final int encryptkey = randgen.nextInt(100) + 1;
  
  public Password(String pass)
  {
    userPass = pass;
  }
  
  public String encryptPass() {

    char[] encryptedAry = new char[userPass.length()];
    
    for(int i = 0; i < userPass.length(); i++) {
         encryptedAry[i] = (char)((int)(userPass.charAt(i)) + encryptkey);
    }
    
    String encryptedPass = new String(encryptedAry);
    return encryptedPass;
  }
  
  public String decryptPass(int key) {

    char[] decryptedAry = new char[userPass.length()];
    
    for(int i = 0; i < userPass.length(); i++) {
         decryptedAry[i] = (char)((int)(userPass.charAt(i)) - key);
    }
    
    String decryptedPass = new String(decryptedAry);
    return decryptedPass;
  }
  
  public int getKey() {
    return encryptkey;
  }
}