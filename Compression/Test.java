import java.io.File;

public class Test {
  public static void main(String[] args) {
    File myFile = new File("helloworld.txt.comp");
    Compression myCmprsFile = new Compression(myFile);
    myCmprsFile.decompressFile();
  }
}