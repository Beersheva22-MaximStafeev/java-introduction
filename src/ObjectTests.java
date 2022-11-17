import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
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
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		Character b = 'v';
		System.out.println((int)helloAr[0]);
		System.out.println((byte)helloAr[0]);
		assertTrue(Strings.isAnagram1("papa", "apap"));
		assertFalse(Strings.isAnagram1("papa", "apafp"));
	}
	
	@Test
	void isAnagram2Test() {
		assertTrue(Strings.isAnagram2("qwe", "ewq"));
		assertFalse(Strings.isAnagram2("qwe", "ewq1"));
	}
	
	@Test
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("qwe", "ewq"));
		assertFalse(Strings.isAnagram("qwe", "ewq1"));
	}
}
