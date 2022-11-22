import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringsTest {

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
}
