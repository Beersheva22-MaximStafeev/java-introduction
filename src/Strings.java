
public class Strings {
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * only one additional array
	 * only symbols or English letters
	 * 1. the same length
	 * 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str, String str2) {
		char[] str1Chars = str.toCharArray();
		char[] str2Chars = str2.toCharArray();
		int[] countChars = new int[Short.MAX_VALUE+1];
		boolean res = str1Chars.length == str2Chars.length;
		if (res) {
			for (int i = 0; i < str1Chars.length; i++) {
				countChars[(short)str1Chars[i]]++;
			}
		}
		int i = 0;
		while (i < str2Chars.length && res) {
			countChars[(short)str2Chars[i]]--;
			res = countChars[(short)str2Chars[i]] >= 0;
			i++;
		}
		return res;
	}
}
