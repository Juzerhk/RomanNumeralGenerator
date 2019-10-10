package romanNumeralGeneratorTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import romanNumeralGenerator.GenerateRomanNumeral;
import romanNumeralGenerator.Main;

public class RomanNumeralGeneratorTest {
	GenerateRomanNumeral generator = new GenerateRomanNumeral();

//	@Test
//	/**
//	 * This  is actually not a test but just a function which will generate Roman numerals between 1 and 3999
//	 */
//	public void generateRomanNumeralTest() {
//		for(int i=1; i < 4000; i++) {
//			String output=generator.generate(i);
//			System.out.println("The generated roman numeral for "+i+" is "+output);
//		}
//	}
	
	@Test
	public void compareNumeralWithNumberTest() {
		System.out.println("CompareNumerals Test started");

		String generateNumeralFor10 = generator.generate(10);
		System.out.println("generateNumeralFor10::"+generateNumeralFor10);
		
		Assert.assertEquals(generateNumeralFor10, "X");
		Assert.assertEquals(generator.generate(19), "XIX");
		Assert.assertEquals(generator.generate(24), "XXIV");
		Assert.assertEquals(generator.generate(28), "XXVIII");
		Assert.assertNotEquals(generator.generate(28), "XXIX");
		Assert.assertEquals(generator.generate(3999), "MMMCMXCIX");
		Assert.assertEquals(generator.generate(90), "XC");
		Assert.assertEquals(generator.generate(40), "XL");
		Assert.assertNotEquals(generator.generate(40), "XXXX");
		
		Assert.assertTrue(generator.generate(64).equals("LXIV"));
		Assert.assertEquals(generator.generate(3994), "MMMCMXCIV");
		Assert.assertFalse(generator.generate(3994).equals("MMMCMXCIIII"));
	
		System.out.println("CompareNumerals Test ended");
	}
	
	@Test
	public void invalidInputTest() {
		System.out.println("InvalidInputTest Test started");

		//When input is decimal, error should be shown
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral("10.11"), "Incorrect input, please enter a integer between 1 and 3999");
		//When input is a string, error should shown
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral("wppo"), "Incorrect input, please enter a integer between 1 and 3999");
		//When input is empty
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral(""), "No value entered");
		//When user wants to quit
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral("q"), "Bye, have a nice day");
		//When the input number is out of range
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral("0"), "Incorrect range, Inputvalue 0 doesn't fall in the range,\nPlease enter any value between 1 and 3999");
		Assert.assertEquals(Main.verifyInputAndGetRomanNumeral("4000"), "Incorrect range, Inputvalue 4000 doesn't fall in the range,\nPlease enter any value between 1 and 3999");

		System.out.println("InvalidInputTest Test ended");
	}
}
