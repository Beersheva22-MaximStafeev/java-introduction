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
		// TO DO Auto-generated method stub
		return number % 10;
	}

	private int getSecondDigit(int number) {
		// TO DO Auto-generated method stub
		return (number / 10) % 10;
	}

	private int getFirstDigit(int number) {
		// TO DO Auto-generated method stub
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
	@Disabled
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
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7e5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f5, BitOperations.invertBitValue(0x3ab7e5, 5));
	}

	@Test
	void revertBitValueTestChecked() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101 
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f5, BitOperations.invertBitValue(0x3ab7d5, 5));
	}
	
	@Test
	void additionalTestNegativeNumbers() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
	
	@Test
	void getSum3Test() {
		assertEquals(3  , Numbers.getSum3(30));
		assertEquals(3  , Numbers.getSum3(1030));
		assertEquals(6  , Numbers.getSum3(123));
		assertEquals(18 , Numbers.getSum3(567));
		assertEquals(18 , Numbers.getSum3(99));
		assertEquals(27 , Numbers.getSum3(9999999));
		assertEquals(14 , Numbers.getSum3(707));
		assertEquals(14 , Numbers.getSum3(7707));
		for (int i = 0; i < 1000; i++) {
			int s = (i / 100) + (i / 10) % 10 + (i % 10);
			assertEquals(s, Numbers.getSum3(i));
		}
	}
	
	@Test
	void isHappyNumberTest() {
		assertEquals(false, Numbers.isHappyNumber(0));
		assertEquals(false, Numbers.isHappyNumber(99999));
		assertEquals(false, Numbers.isHappyNumber(1234567));
		assertEquals(true , Numbers.isHappyNumber(890890));
		assertEquals(true , Numbers.isHappyNumber(129804));
		assertEquals(true , Numbers.isHappyNumber(779977));
		assertEquals(false, Numbers.isHappyNumber(987654));
		assertEquals(true , Numbers.isHappyNumber(654456));
		assertEquals(false, Numbers.isHappyNumber(654457));
	}
	
	@Test
	void getNDigitsTest() {
		int i;
		for (i = 0; i < 10; i++) {
			assertEquals(1, Numbers.getNDigits(i));
		}
		for (i = 10; i < 100; i++) {
			assertEquals(2, Numbers.getNDigits(i));
		}
		for (i = 100; i < 1000; i++) {
			assertEquals(3, Numbers.getNDigits(i));
		}
	}
	
	@Test
	void leadingZerosTest() {
		int i;
		for (i = 0; i < 1; i++) {
			assertEquals(64, BitOperations.leadingZeros(i));
		}
		for (i = 1; i < 2; i++) {
			assertEquals(63, BitOperations.leadingZeros(i));
		}
		for (i = 2; i < 4; i++) {
			assertEquals(62, BitOperations.leadingZeros(i));
		}
		for (i = 4; i < 8; i++) {
			assertEquals(61, BitOperations.leadingZeros(i));
		}
		for (i = 8; i < 16; i++) {
			assertEquals(60, BitOperations.leadingZeros(i));
		}
	}
	
	@Test
	void onesInNumberTest() {
		assertEquals(64, BitOperations.onesInNumber(0xFFFFFFFF));
		assertEquals(60, BitOperations.onesInNumber(0xFF0FFFFF));
		assertEquals(56, BitOperations.onesInNumber(0xFF0FF0FF));
		assertEquals(55, BitOperations.onesInNumber(0xFF0FE0FF));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(1, BitOperations.onesInNumber(2));
	}
	
}
