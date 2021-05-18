package inventoryTimeDate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;


abstract class ParserDate {

	public ParserDate(Path file) {
		// TODO Auto-generated constructor stub

	}
	
	public static void parseFromTXT(String fileStr) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path file = null;
		try {
			file = Path.of(fileStr).getFileName();
		} catch (InvalidPathException e) {
			// TODO Auto-generated catch block
			System.err.format("IOException: %s%n", e);
			//throw e;
			//e.printStackTrace();
		}
		
	
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        if (ArborDateToken.isArborString(line)) {
		        	System.out.println(line);
		        	System.out.println(ArborDateToken.getStatesUS() + " : " +
		        						ArborDateToken.getArborDate());
			        System.out.println();
		        }
		    }
		} catch (IOException x) {
			//throw x;
		    System.err.format("IOException: %s%n", x);
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		try {
			parseFromTXT("ArborDate.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.format(e1.toString());
		}
		
		try {
			parseFromTXT("ArborDate.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
