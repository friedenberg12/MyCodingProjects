import java.util.Scanner;
import java.io.*;

public class Compression {
  
  private File userFile;
  
  public Compression(File newFile) {
    userFile = newFile;
  }
  
  public void compressFile() {
    try {
      Scanner s = new Scanner(userFile);
      try {
        PrintWriter writer = new PrintWriter(userFile.getName() + ".comp", "UTF-8");
      while(s.hasNextLine()) {
        String fileline = s.nextLine();
        fileline = fileline.replaceAll("and", "&");
        fileline = fileline.replaceAll("or", "-");
        fileline = fileline.replaceAll("at", "@");
        writer.println(fileline);
      }
      writer.close();
      }
      catch (UnsupportedEncodingException ex) {
        System.out.println("Sorry. There was an error.");
        System.exit(1);
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("Sorry. The file could not be found");
      System.exit(1);
    }
  }
    
    public void decompressFile() {
    try {
      Scanner s = new Scanner(userFile);
      try {
        PrintWriter writer = new PrintWriter((userFile.getName()).replace(".comp", ""), "UTF-8");
      while(s.hasNextLine()) {
        String fileline = s.nextLine();
        fileline = fileline.replaceAll("&", "and");
        fileline = fileline.replaceAll("-", "or");
        fileline = fileline.replaceAll("@", "at");
        writer.println(fileline);
      }
      writer.close();
      }
      catch (UnsupportedEncodingException ex) {
        System.out.println("Sorry. There was an error.");
        System.exit(1);
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("Sorry. The file could not be found");
      System.exit(1);
    }
  }
}