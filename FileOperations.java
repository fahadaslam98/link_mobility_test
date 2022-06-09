package link_mobility_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FileOperations {

	/**
	 * Method take file path or file name as input and return a List of
	 * lines in that file.
	 * <p>
	 * This method takes file path or file name as input and returns the
	 * lines in the file as List of String
	 * </p>
	 * 
	 * @param fileName C:\\Users\\HP\\Desktop\\clients.txt or clients.txt
	 * @return {@link List<String>} returns List<String> as lines of file
	 */
	public static List<String> readDataFromFile(String fileName) throws IOException {
		// path from where we have to read the file
		File file = new File(fileName);
		// Creating an object of BufferedReader class
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> lines = br.lines().collect(Collectors.toList());
		br.close();
		return lines;

	}
	
	/**
	 * Method take file path or file name as input and create a file there
	 * to store the HashMap
	 * <p>
	 * This method takes file path or file name as input and returns the
	 * lines in the file as List of String
	 * </p>
	 * 
	 * @param fileName C:\\Users\\HP\\Desktop\\clients.txt or clients.txt
	 * @param HashMap of phoneNumbers
	 * @return {@link HashMap<String,Integer>} where phoneNumber = key and no of appearances = value
	 */
	public static void writeBackToFile(String fileName, HashMap<String, Integer> phoneNumbers) throws IOException {
		// for sorting the hash map generated into asecending order
		Map<String, Integer> map = new TreeMap<String, Integer>(phoneNumbers);
		File file = new File("MSIDN_clients.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			bw.write(m.getKey() + ";" + m.getValue());
			bw.newLine();
		}
		bw.close();
	}
}
