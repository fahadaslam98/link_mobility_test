package link_mobility_test;

import java.util.HashMap;
import java.util.List;

public class Utility {

	/**
	 * Method converts phone number to MSIDN number format
	 * <p>
	 * This method take input of phone number and MSIDN prefix, phone number in any
	 * format and converts the number to MSIDN format and returns the resulting
	 * value. <b>Good value check added so if number is already in MSIDN format it
	 * will be returned as is.</b>
	 * </p>
	 * 
	 * @param number 703306661 or 070-330661
	 * @param MSIDN  code +** example +46 or +47
	 * @return MSIDN number +46*********
	 */
	public static String converToMSISDN(String number, String MSIDN) {

		StringBuilder sb = new StringBuilder(number);
		try {
			if (sb.indexOf(MSIDN) == -1) {
				if (sb.indexOf("-") != -1) {
					sb.delete(sb.indexOf("-"), sb.indexOf("-") + 1);
				}

				if (sb.charAt(0) == '0') {
					sb.replace(0, 1, MSIDN);
				} else {
					sb.insert(0, MSIDN);
				}
			}
		} catch (Exception e) {
			System.out.println(number);
		}
		return sb.toString();
	}

	

	/**
	 * Method converts List of phone number to MSIDN number format
	 * <p>
	 * This method take input of List phone number and MSIDN prefix, phone number in any
	 * format and converts the number to MSIDN format and returns a map containing
	 * phone numbers as key and no of times phoneNumber as value, the phone number
	 * appeared in the list.
	 * <br><b>Empty value check added so if number is already in MSIDN format it
	 * will be returned as is.</b>
	 * </p>
	 * 
	 * @param phoneNumbers List [703306661, 070-330661]
	 * @param MSIDN  code +** example +46 or +47
	 * @return {@link HashMap}<String,Integer> phoneNumbers where phoneNumber = key, how many appearances = Integer
	 */
	public static HashMap<String, Integer> convertToMSIDNAndCheckForDuplicates(List<String> phoneNumbers,
			final String MSIDN_CODE) {
		HashMap<String, Integer> duplicate = new HashMap<>();
		String key = "";
		for (int i = 0; i < phoneNumbers.size(); i++) {
			if (!phoneNumbers.get(i).isEmpty())
				key = converToMSISDN(phoneNumbers.get(i), MSIDN_CODE);
			duplicate.put(key, duplicate.getOrDefault(key, 0) + 1);
		}

		return duplicate;
	}


}
