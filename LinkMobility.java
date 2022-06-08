package link_mobility_test;

import java.io.IOException;

public class LinkMobility {

	public static final String MSIDN_CODE = "+46";

	public static void main(String args[]) throws IOException {

		String fileName = "clients.txt";
		FileOperations.writeBackToFile(Utility.convertToMSIDNAndCheckForDuplicates(FileOperations.readDataFromFile(fileName), MSIDN_CODE));
		
	}
	
}
