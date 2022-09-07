package fileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static String path = "src/main/resources/files/books/input.txt";
	
	public static void main(String[] args) {
		readFileData();
	}

	private static void readFileData() {
		
		try {
			
			File f = new File(path);
			Scanner reader = new Scanner(f);
			
			try {			
				if (f.canRead()) {
					while (reader.hasNextLine()) {
						String line = reader.nextLine();
						System.out.println(line);
					}
				} else {
					throw new FileNotFoundException("File is not accesible");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				reader.close();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		
		
		
	}
	
}
