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
}
