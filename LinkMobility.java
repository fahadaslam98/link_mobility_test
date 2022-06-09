package link_mobility_test;

import java.io.IOException;

public class LinkMobility {

	public static final String MSIDN_CODE = "+46";

	public static void main(String args[]) throws IOException {

		String fileName = "clients.txt";
		String reultFile = "MSIDN_clients.txt";
		
		//write the result to file
		FileOperations.writeBackToFile(
				//convert the List of phoneNumber => HashMap of phoneNumber with values as number of appearances
				reultFile, Utility.convertToMSIDNAndCheckForDuplicates(
						//reading the data from the source file and passing with MSIDN_CODE required for the phoneNumbers
						FileOperations.readDataFromFile(fileName), MSIDN_CODE));
		
	}
	
}
