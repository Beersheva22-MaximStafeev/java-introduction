import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsTest {
	public static boolean isAnagramStream(String str1, String str2) {
		return str1.chars().boxed()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.equals(str2.chars().boxed()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}
	
	public static boolean isAnagramSort(String str, String anagram) {
		char[] strChars = str.toCharArray();
		char[] anagramChars = anagram.toCharArray();
		Arrays.sort(strChars);
		Arrays.sort(anagramChars);
		return Arrays.equals(strChars, anagramChars);
	}
	

}
