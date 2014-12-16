import java.io.File;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Compression {
	
	File file;
	String filename;

	public Compression(File _file) {
		file = _file;
		filename = _file.getName().substring(0,_file.getName().indexOf('.'));
	}

	public void compress() {
		Scanner filescan;
		PrintWriter writer;
		List<Integer> binary = new ArrayList<Integer>();
		try {
			filescan = new Scanner(file);
			while(filescan.hasNextLine()) {
				String line = filescan.nextLine();
				for(int i=0;i<line.length();i++) {
					if(Character.isLowerCase(line.charAt(i))) {
						binary.add(Integer.parseInt(Integer.toBinaryString(line.charAt(i)))-1100000);
					} else if(Character.isUpperCase(line.charAt(i))){
						binary.add(Integer.parseInt(Integer.toBinaryString(line.charAt(i)))-1000000);
					} else {
						binary.add(Integer.parseInt(Integer.toBinaryString(line.charAt(i))));
					}
    			}
    			binary.add(1101);
			}
			writer = new PrintWriter(filename + ".cmp", "UTF-8");
			for(int i=0;i<binary.size();i++) {
				writer.print((char)binToDec(binary.get(i)));
				writer.print("/");
			}
			writer.close();
		} catch(UnsupportedEncodingException | FileNotFoundException ex) {
			System.err.println("Unsupported Encoding");
			System.exit(1);
		}
	}

	private int binToDec(int bin) {
         
        int dec = 0;
        int power = 0;
        while(true){
            if(bin == 0){
                break;
            } else {
                int tmp = bin%10;
                dec += tmp*Math.pow(2, power);
                bin = bin/10;
                power++;
            }
        }
        return dec;
    }
}