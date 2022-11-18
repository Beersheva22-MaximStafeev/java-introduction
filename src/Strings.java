import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Strings {
	public static boolean isAnagram1(String str, String anagram) {
		char[] strChars = str.toCharArray();
		char[] anagramChars = anagram.toCharArray();
		Arrays.sort(strChars);
		Arrays.sort(anagramChars);
		return Arrays.equals(strChars, anagramChars);
	}
	
	public static boolean isAnagram2(String str1, String str2) {
		return str1.chars().boxed()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.equals(str2.chars().boxed()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		str1.cha
	}
	
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
