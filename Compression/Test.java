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
    File myFile = new File("helloworld.txt.comp");
    Compression myCmprsFile = new Compression(myFile);
    myCmprsFile.decompressFile();
  }
}