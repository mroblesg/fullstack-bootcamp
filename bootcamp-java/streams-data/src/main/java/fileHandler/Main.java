package fileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static String path = "src/main/resources/files/books/input.txt";

	public static void main(String[] args) {
		//readFileDataLine();
		readFileDataParallel();
	}

	private static void readFileDataLine() {
		
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
					throw new IOException("File is not accesible");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				reader.close();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	private static void readFileDataParallel() {

		File f = new File(path);

		try {
			if (f.canRead()) {

				List<String> text = Files.readAllLines(f.toPath());
				text.parallelStream().forEach((d) -> {System.out.println(d);});
				
			} else {
				throw new IOException("File can't be read");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
