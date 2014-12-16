/*
 *  Compression Binary
 *
 *  (c)2014 by David Friedenberg
 *
 *  This code was written by David Friedenberg
 *  for public use. Have fun!
*/

import java.io.PrintWriter;
import java.util.Scanner;

public class Encryption {
  
  String pass;
  char[] letters;
  int[] nums;
  
  public Encryption(String _pass) {
    pass = _pass;
    nums = new int[26];
    letters = {
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };
  }

  public String encrypt() {
    
    String encrypted = "";
    
    for(int i=0;i<nums.length;i++) {
      nums[i] = (int)(Math.random()*1000);
      if(i > 0) {
        for(int j=0;j<i;j++) {
          if(nums[i] == nums[j]) {
            i--;
          }
        }
      }
    }
    
    for(int i=0;i<pass.length();i++) {
      for(int j=0;j<letters.length;j++) {
        if(pass.charAt(i) == letters[j]) {
          encrypted += Integer.toString(nums[j]);
          encrypted += " ";
        }
      }
    }
    
    PrintWriter pw = new PrintWriter("key","UTF-8");
    for(int i=0;i<nums.length;i++) {
      pw.println(Integer.toString(nums[i]))
    }
    pw.close();
    System.out.println("Please save the \"key\" file to use for password decryption.");
    
    return encrypted;
  }
  
  
  public String decrypt(File _key) {
    
    String fileline;
    Scanner filescan = new Scanner(_key);
    String decrypted;
    int[] coded = new int[26];
    int x = 0;
    
    if(!(_key.getName().equals("key"))) {
      System.out.println("This is not a valid file. Please use the \"key\" file given during the encryption process.");
      System.exit(0);
    }
    
    while(filescan.hasNextLine()) {
      fileline = filescan.nextLine();
      coded[x] = Integer.parseInt(fileline);
    }
    
    for(int i=0;i<coded.length;i++) {
      
}