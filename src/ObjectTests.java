import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {
		Integer a = 10;
		Integer b = 11;
		assertEquals(++a, b);
		assertTrue(a == b);

		Integer c = 200;
		Integer d = 201;
		assertTrue(c.equals(200));
		assertEquals(++c, d);
		assertEquals(c, d);
		// !!!! c,d not in [-128..127], so it is different objects
		assertFalse(c == d); 

		int e = 201;
		int f = 201;
		assertEquals(e, f);
		assertTrue(e == f); 
	}
	
	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		Character b = 'v';
		assertEquals('v', b);
	}
	

	@Test
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("qwe", "ewq"));
		assertFalse(Strings.isAnagram("qwe", "ewq1"));
		assertTrue(Strings.isAnagram("papa", "apap"));
		assertFalse(Strings.isAnagram("papa", "apafp"));
		assertTrue(Strings.isAnagram("pap a", "ap ap"));
		assertFalse(Strings.isAnagram("p apa", "ap  afp"));
	}
	
	@Test
	void sortStringNumbersTest() {
		String[][][] tests = {
				{
					{"12","13","10"},
					{"10","12","13"}
				},
				{
					{"1","4","3"},
					{"1","3","4"}
				},
				{
					{"6","5","4"},
					{"4","5","6"}
				}
		};
		for (int i = 0; i < tests.length; i++) {
			Strings.sortStringNumbers(tests[i][0]);
			assertArrayEquals(tests[i][0], tests[i][1]);
		}
	}
}
