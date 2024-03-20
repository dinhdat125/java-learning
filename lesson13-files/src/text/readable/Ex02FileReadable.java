package text.readable;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.FileUtils;

public class Ex02FileReadable {

	public static void main(String[] args) {
		/*
		 * read data from file input.txt(amount, String, String, ...)
		 * -> List<String> -> get numbers -> sort
		 * -> write result in file output.txt
		 */
		File file = new File("class/data/input.txt");
		
		if (file.exists()) {
			var lines = readLines(file.toPath());
			
			if (!lines.isEmpty()) {
				lines.remove(0);
				var numbers = lines.stream()
						.flatMap(line -> Arrays.stream(line.split("[a-z]+")))
						.filter(numberText -> !numberText.isEmpty())
						.map(Integer::parseInt)
						.distinct()
						.sorted()
						.toList();
				numbers.forEach(System.out::println);
				
				// write file
				File opFile = FileUtils.createFile("class/data/output.txt");
				if (opFile.exists()) {
					var opLines = numbers.stream()
							.map(String::valueOf)
							.toList();
					try {
						Files.write(opFile.toPath(), opLines);
						System.out.println("Write result in file " + opFile.getName() + " success!");
						Desktop.getDesktop().open(opFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private static List<String> readLines(Path path) {
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
