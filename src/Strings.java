
public class Strings {
	public static boolean isAnagram(String str, String anagram) {
		char[] strChars = str.toCharArray();
		char[] anagramChars = anagram.toCharArray();
		int[] countChars = new int[Short.MAX_VALUE+1];
		boolean res = true;
		for (int i = 0; i < strChars.length; i++) {
			countChars[(int)strChars[i]]++;
		}
		for (int i = 0; i < anagramChars.length; i++) {
			countChars[(int)anagramChars[i]]--;
		}
		int i = 0;
		while (res && i < countChars.length) {
			res = countChars[i] == 0;
			i++;
		}
		return res;
	}
}
