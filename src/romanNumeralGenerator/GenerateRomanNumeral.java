package romanNumeralGenerator;

import java.util.TreeMap;

/**
 * @author juzer
 *
 */
public class GenerateRomanNumeral implements RomanNumeralGenerator {

	// Approach A
	
	// Treemap creates a treeMapping of keys and its corresponding values and keeps the entry in the sorted order as per the natural ordering rule.
    TreeMap<Integer, String> numberToNumeralMapping = new TreeMap<Integer, String>();
    
     {
		numberToNumeralMapping.put(1, "I");
		numberToNumeralMapping.put(4, "IV");
		numberToNumeralMapping.put(5, "V");
		numberToNumeralMapping.put(9, "IX");
		numberToNumeralMapping.put(10, "X");
		numberToNumeralMapping.put(40, "XL");
		numberToNumeralMapping.put(50, "L");
		numberToNumeralMapping.put(90, "XC");
		numberToNumeralMapping.put(100, "C");
		numberToNumeralMapping.put(400, "CD");
		numberToNumeralMapping.put(500, "D");
		numberToNumeralMapping.put(900, "CM");
		numberToNumeralMapping.put(1000, "M");
    }

     /**
      * @param number
      * returns the generated Roman numeral for a given number
      */
	@Override
	public String generate(int number) {
		String generatedRomanNumeral = "";
		try {
			int key =  numberToNumeralMapping.floorKey(number); // floorkey will return the greatest key which is less than or equal to the given key(i.e number)
			if ( number == key ) { // If the number and key matches
				generatedRomanNumeral=numberToNumeralMapping.get(number); // get the corresponding value for the matching key
				return  generatedRomanNumeral;
			}
			//get the corresponding value for the matching key and generate the numeral for the remaining number which is left after subtracting from the key
			generatedRomanNumeral=numberToNumeralMapping.get(key) + generate(number-key); 
			return generatedRomanNumeral;
			
		} catch(Exception e) {
			System.out.println("Error :" +e);
			System.exit(0);
		}
		return generatedRomanNumeral;
    }

	// Approach B
		
	//	@Override
	//	public String generate(int number) {
	//		String output="";
	//		while(number >= 1000 ) {			
	//			output+="M";
	//			number=number-1000;
	//		}
	//		while(number >= 900) {
	//			output+="CM";
	//			number=number-900;
	//		}
	//		while(number >= 500) {				
	//			output+="D";
	//			number=number-500;
	//		}
	//		while (number >= 400) {
	//			output+="CD";
	//			number=number-400;
	//		}
	//		while(number >= 100) {
	//			output+="C";
	//			number=number-100;
	//		}
	//		while (number >= 90) {
	//			output+="XC";
	//			number=number-90;
	//		}
	//		while(number >= 50) {
	//			output+="L";
	//			number=number-50;
	//		}
	//		while (number >= 40) {
	//			output+="XL";
	//			number=number-40;
	//		}
	//		while(number >= 10) {		
	//			output+="X";
	//			number=number-10;
	//		}
	//		while (number >= 9) {
	//			output+="IX";
	//			number=number-9;
	//		}
	//		while(number >= 5) {		
	//			output+="V";
	//			number=number-5;
	//		}
	//		while (number >= 4) {
	//			output+="IV";
	//			number=number-4;	
	//		}
	//		while(number >= 1) {
	//			output+="I";
	//			number=number-1;
	//		}
	//
	//		return output;
	//	}

}
