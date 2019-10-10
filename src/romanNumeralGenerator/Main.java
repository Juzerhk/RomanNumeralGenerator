/**
 * 
 */
package romanNumeralGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author juzer
 *
 */
public class Main {
	static GenerateRomanNumeral generator = new GenerateRomanNumeral();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String decision = "";
		System.out.printf("A simple program to convert integers to roman numerals\n");
		
		do {
			System.out.printf("Please enter a number between 1 to 3999, press q to quit\n");

			String inputValue = reader.readLine(); // Reading data using readLine
			String outputValue = verifyInputAndGetRomanNumeral(inputValue);
			System.out.println(outputValue);
			if(outputValue.equals("Bye, have a nice day")) {
				System.exit(0);
			}
			System.out.printf("Do yo want to continue? y/n\n"); // check if user wants to continue
			decision = reader.readLine();

		} while (decision.equals("y"));

		System.out.println("Program ended, have a nice day");
	}

	public static String verifyInputAndGetRomanNumeral(String inputValue) {
		Boolean isInputNumber = true;
		int inputNumber = 0;
		String output="";
		try {
			inputNumber = Integer.parseInt(inputValue);
		} catch(NumberFormatException e) { // If input is not a number
			isInputNumber= false; 
		}

		if(!isInputNumber) { 				// If input is not a number
			if(inputValue.equals("q")) { 		// If users want to exit
				output = "Bye, have a nice day";
//				System.out.println("Bye, have a nice day");
			} else if (inputValue.equals("")) { // If input is empty
				output = "No value entered";
			} else {
				output = "Incorrect input, please enter a integer between 1 and 3999";
			}
		} else if(isInputNumber) { 		// If entered input is a number 
			if(inputNumber > 3999 || inputNumber <= 0 ) { // check if it falls in the range.
				output = "Incorrect range, Inputvalue "+inputNumber+" doesn't fall in the range,\nPlease enter any value between 1 and 3999";
				
			} else if(inputNumber <= 3999 && inputNumber >= 1) { // if it is in the range, then get the corresponding Roman numeral
				String value = generator.generate(inputNumber);
				output = "output numeral::" + value;
			}
		}
		return output;
	}
}
