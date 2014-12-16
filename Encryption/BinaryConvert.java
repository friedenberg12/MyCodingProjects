/*
 *  Compression Binary
 *
 *  (c)2014 by David Friedenberg
 *
 *  This code was written by David Friedenberg
 *  for public use. Have fun!
*/

public class BinaryConvert {
  public static void main(String[] args) {
    String str = "Hello World";
    for(int i = 0; i < str.length(); i++) {
      String binary = Integer.toBinaryString(str.charAt(i));
      /*if(binary.length() == 7) {
        System.out.print("0");
      } else if(binary.length() == 6) {
        System.out.print("00");
      } else if(binary.length() == 6) {
        System.out.print("000");
      } else if(binary.length() == 6) {
        System.out.print("0000");
      } else if(binary.length() == 6) {
        System.out.print("00000");
      } else if(binary.length() == 6) {
        System.out.print("000000");
      } else if(binary.length() == 6) {
        System.out.print("0000000");
      }*/
      System.out.print(binary + " ");
    }
  }
}