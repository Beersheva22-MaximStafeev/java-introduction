package telran.digital.numbers.test;

import org.junit.jupiter.api.*;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(verticalLine(30, 4));
	}

	@Test
	@Disabled
	void twoVerticalLineTest() {
		displayStrings(twoVerticalLine(30, 10, 5));
	}
	
	@Test
	@Disabled
	void printTest() {
		displayStrings(digit0(8, 8));
		displayStrings(digit1(8, 8));
	}
	
	@Test
	void printNumber() {
		displayDigitalNumber(1234567890, 10, 4, 7);
	}

}
