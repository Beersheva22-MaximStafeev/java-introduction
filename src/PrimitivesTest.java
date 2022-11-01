import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test 
	
	void dataTypeTest() {
//		fail("Not yet implemented");
		int b = 10;
		short a = 20;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		float f = 10.2f;
		double dd = 0.3;
		boolean bb = false;
		
		int b2 = 0xffffffff; // = -1
		
		
//		assertEquals(20, b); // first - what we know what should (expect), second - what we count
		assertEquals(10, b);
		assertEquals(10.0, b);
//		assertEquals(10.1, b);
		assertEquals(b, l);
//		assertEquals(1000, b1);
		assertEquals(-1, b2);
		assertEquals(0, b2+1);
	}
	
	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
		
		assertEquals(3, getDigit(0, number));
		assertEquals(2, getDigit(1, number));
		assertEquals(1, getDigit(2, number));
		assertEquals(0, getDigit(3, number));
	}

	private int getThirdDigit(int number) {
		// TODO Auto-generated method stub
		return number % 10;
	}

	private int getSecondDigit(int number) {
		// TODO Auto-generated method stub
		return (number / 10) % 10;
	}

	private int getFirstDigit(int number) {
		// TODO Auto-generated method stub
		return (number / 100) % 10;
	}
	
	private int powOf10(int pow) {
		int res = 1;
		while (pow > 0) {
			res = res * 10;
			pow--;
		}
		return res;
	}
	
	private int getDigit(int digitNo, int number) {
		return (number / this.powOf10(digitNo)) % 10;
	}
	
	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
	}

	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	
	@Test
	void setBitValueTestChecked() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	
	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7e5, BitOperations.revertBitValue(number, 5));
		assertEquals(0x3ab7f5, BitOperations.revertBitValue(0x3ab7e5, 5));
	}

	@Test
	void revertBitValueTestChecked() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7d5, BitOperations.revertBitValue(number, 5));
		assertEquals(0x3ab7f5, BitOperations.revertBitValue(0x3ab7d5, 5));
	}
	
	@Test
	void newTest() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.revertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
}
