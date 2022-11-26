package telran.text;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static telran.text.Strings.*;

class StringsTest {


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

	@Test
	void javaVariableTest() {
		String[] testsGood = new String[] {
				"__",
				"java",
				"_java",
				"java_1_2",
				"$"
		};
		String[] testsBad = new String[] {
				"_",
				"1java",
				"$ _"
		};
		for (String i: testsGood) {
			assertTrue(i.matches(Strings.javaNameExp()));
		}
		for (String i: testsBad) {
			assertFalse(i.matches(Strings.javaNameExp()));
		}
	}

	@Test
	void ipV4OctetTest() {
		String[] testsGood = new String[] {
				"0",
				"10",
				"15",
				"245",
				"221"
		};
		String[] testsBad = new String[] {
				"01",
				"00",
				"05",
				"256"
		};
		for (Integer i = 0; i < 256; i++) {
			assertTrue(i.toString().matches(Strings.ipV4Octet()));
		}
		for (Integer i = 256; i < 1000; i++) {
			assertFalse(i.toString().matches(Strings.ipV4Octet()));
		}
		for (Integer i = -256; i < 0; i++) {
			assertFalse(i.toString().matches(Strings.ipV4Octet()));
		}
		for (String i: testsGood) {
			assertTrue(i.matches(Strings.ipV4Octet()));
		}
		for (String i: testsBad) {
			assertFalse(i.matches(Strings.ipV4Octet()));
		}
	}
	
	@Test
	void ipV4Test() {
		String[] testsGood = new String[] {
				"8.8.8.8",
				"255.255.255.0",
				"192.168.1.1",
				"0.0.0.0"
		};
		String[] testsBad = new String[] {
				"192.168.1.1.1",
				"0.0.0.0.0",
				"05"
		};
		for (String i: testsGood) {
			assertTrue(i.matches(Strings.ipV4()));
		}
		for (String i: testsBad) {
			assertFalse(i.matches(Strings.ipV4()));
		}
	}
	
	@Test
	void isArithmeticExpressionTest() {
		String[] testsGood = new String[] {
				"1+2+3",
				"((((1+2))+3",
				"((1+(((1+33))+(((23))"
		};
		String[] testsBad = new String[] {
				"1+))*asdf*asdf",
				"))F/sdf/sadf",
				"3233+23+)4"
		};
		for (String i: testsGood) {
			assertTrue(isArithmeticExpression(i));
		}
		for (String i: testsBad) {
			assertFalse(isArithmeticExpression(i));
		}
	}
	
	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertEquals(1, computeArithmenticExpression("1", null, null));
		assertEquals(43, computeArithmenticExpression("2*2*(10 + 3)", null, null));
		assertEquals(10.5, computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertEquals(10.5, computeArithmenticExpression("((a) + 2) + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] {2, 1},
				new String[] {"a", "c"})));
	}

	@Test
	void checkBracesTest() {
		String[] testsGood = new String[] {
				"(())",
				"( ( ( ) ) ( ) ( ) )",
				"()()()()(())(())((((()))))"
		};
		String[] testsBad = new String[] {
				"))",
				"(())(())(())()())",
				"()(())()(()()())())()()(())(()()()"
		};
		for (String i: testsGood) {
			assertTrue(checkBraces(i));
		}
		for (String i: testsBad) {
			assertFalse(checkBraces(i));
		}
	}
}
