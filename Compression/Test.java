/*
 *  Compression Test
 *
 *  (c)2014 by David Friedenberg
 *
 *  This code was written by David Friedenberg
 *  for public use. Have fun!
*/

import java.io.File;

public class Test {
  public static void main(String[] args) {
    File myFile = new File("test.txt");
    Compression myCmprsFile = new Compression(myFile);
    long start = System.currentTimeMillis();
    myCmprsFile.compress();
    long end = System.currentTimeMillis();
    System.out.println((end - start)/1000.0);
  }
}