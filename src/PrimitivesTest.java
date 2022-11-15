import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
//		fail("Not yet implemented");
		int b = 10;
//		short a = 20;
//		char c = 'd';
		long l = (long) 10.1;
//		byte b1 = (byte) 1000;
//		float f = 10.2f;
//		double dd = 0.3;
//		boolean bb = false;

		int b2 = 0xffffffff; // = -1

//		assertEquals(20, b); // first - what we know what should (expect), second - what we count
		assertEquals(10, b);
		assertEquals(10.0, b);
//		assertEquals(10.1, b);
		assertEquals(b, l);
//		assertEquals(1000, b1);
		assertEquals(-1, b2);
		assertEquals(0, b2 + 1);
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
	@Disabled
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
	@Disabled
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
	@Disabled
	void revertBitValueTestChecked() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f5, BitOperations.invertBitValue(0x3ab7d5, 5));
	}

	@Test
	@Disabled
	void additionalTestNegativeNumbers() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}

	@Test
	@Disabled
	void getSumOfLastDigitsTest() {
		assertEquals(3, Numbers.getSumOfLastDigits(30, 3));
		assertEquals(3, Numbers.getSumOfLastDigits(1030, 3));
		assertEquals(4, Numbers.getSumOfLastDigits(1030, 4));
		assertEquals(6, Numbers.getSumOfLastDigits(123, 3));
		assertEquals(6, Numbers.getSumOfLastDigits(123, 4));
		assertEquals(6, Numbers.getSumOfLastDigits(123, 5));
		assertEquals(18, Numbers.getSumOfLastDigits(567, 3));
		assertEquals(9, Numbers.getSumOfLastDigits(99, 1));
		assertEquals(18, Numbers.getSumOfLastDigits(99, 2));
		assertEquals(18, Numbers.getSumOfLastDigits(99, 3));
		for (int i = 0; i < 10; i++) {
			assertEquals(9 * i, Numbers.getSumOfLastDigits(999999999, i));
		}
		assertEquals(27, Numbers.getSumOfLastDigits(9999999, 3));
		assertEquals(14, Numbers.getSumOfLastDigits(707, 3));
		assertEquals(14, Numbers.getSumOfLastDigits(7707, 3));
		for (int i = 0; i < 1000; i++) {
			int s = (i / 100) + (i / 10) % 10 + (i % 10);
			assertEquals(s, Numbers.getSumOfLastDigits(i, 3));
		}
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		assertEquals(false, Numbers.isHappyNumber(0));
		assertEquals(false, Numbers.isHappyNumber(99999));
		assertEquals(false, Numbers.isHappyNumber(1234567));
		assertEquals(true, Numbers.isHappyNumber(890890));
		assertEquals(true, Numbers.isHappyNumber(129804));
		assertEquals(true, Numbers.isHappyNumber(779977));
		assertEquals(false, Numbers.isHappyNumber(987654));
		assertEquals(true, Numbers.isHappyNumber(654456));
		assertEquals(false, Numbers.isHappyNumber(654457));
		assertFalse(Numbers.isHappyNumber(654457));
		assertTrue(Numbers.isHappyNumber(654456));
	}
	
	@Test
	@Disabled
	void getSumDigitsTest() {
		assertEquals(1, Numbers.getSumDigits(10));
		assertEquals(3, Numbers.getSumDigits(30));
		assertEquals(9, Numbers.getSumDigits(234));
		assertEquals(17, Numbers.getSumDigits(575));
	}
	
	@Test
	@Disabled
	void isHappyNumberGoodTest() {
		for (int i = 100000; i < 1000000; i++) {
//			System.out.println(i);
			assertEquals(Numbers.isHappyNumber(i), Numbers.isHappyNumberGood(i));
		}
	}

	@Test
	@Disabled
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
	@Disabled
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
	@Disabled
	void onesInNumberTest() {
		assertEquals(64, BitOperations.onesInNumber(0xFFFFFFFF));
		assertEquals(60, BitOperations.onesInNumber(0xFF0FFFFF));
		assertEquals(56, BitOperations.onesInNumber(0xFF0FF0FF));
		assertEquals(55, BitOperations.onesInNumber(0xFF0FE0FF));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(1, BitOperations.onesInNumber(2));
	}
	
	@Test
	@Disabled
	void getDigitsTest() {
		int[] expected = {1,2,3,4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int[] arr = {1,2,3,4};
		int expectedNumber = 1234;
		assertEquals(1634, Numbers.getNumberFromDigits(new int[]{1,6,3,4})); 
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(arr));
	}
	
	@Test
	@Disabled
	void countCheckSumTest() {
		assertEquals(40, IsraelIdentity.countCheckSum(123456782));
	}
	
	@Test
	@Disabled
	void generateRandomIdTest() {
		for (int i = 0; i < 100; i++) {
			int newId = IsraelIdentity.generateRandomId();
			System.out.println(newId);
			assertTrue(IsraelIdentity.verify(newId));
		}
		
		
	}
	
	@Test
	@Disabled
	void addsNumberTest() {
		assertArrayEquals(new int[] {1,2,3,4}, MyArrays.addsNumber(new int[] {1,2,3}, 4));
		assertArrayEquals(new int[] {1,2,3,-4}, MyArrays.addsNumber(new int[] {1,2,3}, -4));
	}
	
	@Test
	@Disabled
	void removeNumberTest() {
		assertArrayEquals(new int[] {1,2,3}, MyArrays.removeNumber(new int[] {1,2,3}, -1));
		assertArrayEquals(new int[] {2,3}, MyArrays.removeNumber(new int[] {1,2,3}, 0));
		assertArrayEquals(new int[] {1,3}, MyArrays.removeNumber(new int[] {1,2,3}, 1));
		assertArrayEquals(new int[] {1,2}, MyArrays.removeNumber(new int[] {1,2,3}, 2));
		assertArrayEquals(new int[] {1,2,3}, MyArrays.removeNumber(new int[] {1,2,3}, 3));
		assertArrayEquals(new int[] {}, MyArrays.removeNumber(new int[] {}, 3));
	}
	
	@Test
	@Disabled
	void insertSortedTest() {
		assertArrayEquals(new int[] {-101,2,4,6}, MyArrays.insertSorted(new int[] {2,4,6}, -101));
		assertArrayEquals(new int[] {1,2,4,6}, MyArrays.insertSorted(new int[] {2,4,6}, 1));
		assertArrayEquals(new int[] {2,2,4,6}, MyArrays.insertSorted(new int[] {2,4,6}, 2));
		assertArrayEquals(new int[] {2,3,4,6}, MyArrays.insertSorted(new int[] {2,4,6}, 3));
		assertArrayEquals(new int[] {2,4,4,6}, MyArrays.insertSorted(new int[] {2,4,6}, 4));
		assertArrayEquals(new int[] {2,4,5,6}, MyArrays.insertSorted(new int[] {2,4,6}, 5));
		assertArrayEquals(new int[] {2,4,6,6}, MyArrays.insertSorted(new int[] {2,4,6}, 6));
		assertArrayEquals(new int[] {2,4,6,7}, MyArrays.insertSorted(new int[] {2,4,6}, 7));
		assertArrayEquals(new int[] {2,4,6,707}, MyArrays.insertSorted(new int[] {2,4,6}, 707));

		assertArrayEquals(new int[] {1}, MyArrays.insertSorted(new int[] {}, 1));
		assertArrayEquals(new int[] {1,2}, MyArrays.insertSorted(new int[] {2}, 1));
		assertArrayEquals(new int[] {1,2}, MyArrays.insertSorted(new int[] {1}, 2));
		assertArrayEquals(new int[] {1,1}, MyArrays.insertSorted(new int[] {1}, 1));
	}
	
	@Test
	void binarySearchTest() {
		assertEquals(1, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2));
		assertEquals(1, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2));
		assertEquals(0, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 1));
		assertEquals(21, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4}, 4));
		assertEquals(-23, MyArrays.binarySearch(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4}, 5));
		assertEquals(0, MyArrays.binarySearch(new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 2));
		assertEquals(-1, MyArrays.binarySearch(new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 1));
		assertEquals(-21, MyArrays.binarySearch(new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 3));
		for (int i = 1; i < 8; i++) {
			assertEquals(Arrays.binarySearch(new int[] {2,4,6}, i), MyArrays.binarySearch(new int[] {2,4,6}, i));
		}
	}
	
	@Test
	void bubbleSortTest() {
		int test[][][] = {
				{{ 1, 2, 3, 10, -1, 5, 6 },{-1, 1, 2, 3,  5, 6 , 10}},
				{{ 1, 2, 3, 4, 5, 10 },{ 1, 2, 3, 4, 5, 10 }},
				{{ 5, 1, 2, 4, 6, 10 },{  1, 2, 4,5, 6, 10 }},
				{{ 1, 5, 2, 4, 3, 10 },{ 1,  2,  3,4, 5,10 }},
				{{ 1, 3, 2, 5, 4, 10, 8 },{ 1, 2,3, 4,  5, 8, 10 }},
				{{1, 3, 20, 4, 5, 6, 10},{1, 3, 4, 5, 6, 10, 20}},
				{{1, 3, 20, 4, 5, 11, 2},{1, 2, 3, 4, 5, 11, 20}},
				{{ 10, 2, 3, 4, 1 },{  1 ,2, 3, 4, 10}},
				{{ 1, 2, 4, 3, 5, 10 },{ 1, 2,  3,4, 5, 10 }},
				{{ 1, 2, 3, 10, 5, 4 },{ 1, 2, 3, 4, 5, 10 }},
				{{ 1, 5, 3, 4, 2, 10 },{ 1, 2, 3, 4, 5, 10 }},
				{ { 1, 2, 3, 4, 10, 5 }, { 1, 2, 3, 4, 5, 10 }},
				{{ 2, 1, -3, 4, 5, 10 },{ -3, 1, 2, 4, 5, 10 }},
				{{ 3, 2, 1, 4, 5, 6 },{ 1, 2, 3, 4, 5, 6 }}				
		};
		for (int i = 0; i < test.length; i++) {
			MyArrays.bubbleSort(test[i][0]);
			assertArrayEquals(test[i][1], test[i][0]);
		}

	}
	
	@Test
	void bubbleSortTest2() {
		int test[][] = {
				{ 1, 2, 3, 10, -1, 5, 6 },
				{ 1, 2, 3, 4, 5, 10 },
				{ 5, 1, 2, 4, 6, 10 },
				{ 1, 5, 2, 4, 3, 10 },
				{ 1, 3, 2, 5, 4, 10, 8 },
				{1, 3, 20, 4, 5, 6, 10},
				{1, 3, 20, 4, 5, 11, 2},
				{ 10, 2, 3, 4, 1 },
				{ 1, 2, 4, 3, 5, 10 },
				{ 1, 2, 3, 10, 5, 4 },
				{ 1, 5, 3, 4, 2, 10 },
				{ 1, 2, 3, 4, 10, 5 },
				{ 2, 1, -3, 4, 5, 10 },
				{ 3, 2, 1, 4, 5, 6 }				
		};
		for (int i = 0; i < test.length; i++) {
			int[] testArr = Arrays.copyOf(test[i], test[i].length);
			MyArrays.bubbleSort(test[i]);
			Arrays.sort(testArr);
			assertArrayEquals(testArr, test[i]);
		}

	}
	
	@Test
	void isOneSwapTestFalse() {
		int[][] ar = {
			{ 1, 2, 3, 10, -1, 5, 6 },
			{ 1, 2, 3, 4, 5, 10 },
			{ 5, 1, 2, 4, 6, 10 },
			{ 1, 5, 2, 4, 3, 10 },
			{ 1, 3, 2, 5, 4, 10, 8 },
			{ 1, 3, 20, 4, 5, 6, 10 },
			{ 1, 3, 20, 4, 5, 11, 2 },
			{1},
			{1,2},
			{ 1, 2, 3, 10, 16, 16, 11, 10, 20 },
			{ 1, 2, 3, 10, 16, 11, 11, 15, 20 },
			{1,2,2}
		};
		for (int i = 0; i < ar.length; i++) {
			assertFalse(MyArrays.isOneSwapForSorted(ar[i]));
		}
		assertFalse(MyArrays.isOneSwapForSorted(new int[] { 1, 2, 3, 10, 16, 11, 11, 15, 20 }));
	}

	@Test
	void isOneSwapTestTrue() {
		int[][] ar = {
			{ 10, 2, 3, 4, 1 },
			{ 1, 2, 4, 3, 5, 10 },
			{ 1, 2, 3, 10, 5, 4 },
			{ 1, 5, 3, 4, 2, 10 },
			{ 1, 2, 3, 4, 10, 5 },
			{ 2, 1, -3, 4, 5, 10 },
			{ 3, 2, 1, 4, 5, 6 },
			{2,1},
			{1,2,5,4,4,4,4,4,2,5,5,6},
			{2,2,2,2,1},
			{3,2,2,2,2},
			{ 3, 3, 6, 3, 3, 6, 6, 3, 6, 6 },
			{ 5, 4, 4, 4, 4 },
			{ 5, 5, 5, 5, 4 },
			{ 1, 2, 3, 10, 16, 11, 11, 10, 20 },
			{ 1, 2, 3, 10, 16, 11, 11, 11, 20 },
			{ 1, 2, 3, 10, 16, 11, 11, 16, 20 },
			{ 1, 2, 3, 10, 16, 16, 15, 16, 20 }

		};
		for (int i = 0; i < ar.length; i++) {
			assertTrue(MyArrays.isOneSwapForSorted(ar[i]));
		}
	}
	
	@Test
	void isSum2Test() {
		assertTrue(MyArrays.isSum2(new short[] {1,2,3}, 3));
		assertTrue(MyArrays.isSum2(new short[] {1,2,3}, 4));
		assertTrue(MyArrays.isSum2(new short[] {1,2,3}, 5));
		assertTrue(MyArrays.isSum2(new short[] {2,2}, 4));
		assertTrue(MyArrays.isSum2(new short[] {1,2,2,3}, 4));
		assertTrue(MyArrays.isSum2(new short[] { 0, 100, 2, 3, 4, 22 }, 6));
		assertTrue(MyArrays.isSum2(new short[] { 2, 3, 4, 0x7FFF, 0x7FF0, 22 }, 0xFFEF));
		
		assertFalse(MyArrays.isSum2(new short[] {1,2,3}, 1));
		assertFalse(MyArrays.isSum2(new short[] {1,2,3}, 2));
		assertFalse(MyArrays.isSum2(new short[] {1,2,3}, 6));
		assertFalse(MyArrays.isSum2(new short[] {2,2}, 3));
		assertFalse(MyArrays.isSum2(new short[] {2,2}, 5));
		assertFalse(MyArrays.isSum2(new short[] { 4, 2, 2, 2, 2, 2 }, 8));
	}
}
