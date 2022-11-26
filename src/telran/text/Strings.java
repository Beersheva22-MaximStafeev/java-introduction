package telran.text;

import java.util.Arrays;

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
	
	public static void sortStringNumbers(String[] array) {
		byte[] sorted = new byte[getByteIndex(Byte.MAX_VALUE)+1];
		for (int i = 0; i < array.length; i++) {
			sorted[getByteIndex(Byte.parseByte(array[i]))]++;
		}
		int cur = 0;
		Integer i = (int) Byte.MIN_VALUE;
		while (i <= Byte.MAX_VALUE && cur < array.length) {
			int charIndex = getByteIndex(i);
			while (sorted[charIndex] > 0) {
				array[cur] = i.toString();
				sorted[charIndex]--;
				cur++;
			}
			i++;
		}
	}
	
	private static int getByteIndex(int i) {
		return -Byte.MIN_VALUE + i;
	}
	
	/**
	 * 
	 * @return RegExp, matches to a correct javaName
	 */
	public static String javaNameExp() {
		// start with letter, $, _
		// but if starts with _, should be another symbol
		return "([a-zA-Z$][\\w$]*|_[\\w$]+)";
	}
	
	/**
	 * 
	 * @return RegExp for 0-255
	 */
	public static String ipV4Octet() {
		//1-255 without leading zeroes
		return "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
	}
	
	/**
	 * 
	 * @return RegExp for ip address v4
	 */
	public static String ipV4() {
		String octet = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octet) ;
	}

	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		// FIX ME
		// adds checking right placing the braces

		return String.format("%1$s(%2$s%1$s)*", "\\(*" + operandExp + "\\)*", operatorExp);
	}
	
	private static String doubleExp() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	private static String operand() {
		// FIX ME
		// adds possibility of using Java variables
		return String.format("(%s|%s)", doubleExp(), javaNameExp());
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {

		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
		// 10 (* 2)
		// 10 * 2(())
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
			
		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if(!Double.isNaN(operand2)) {
			switch(operator) {
				case "+": res = operand1 + operand2; break;
				case "-": res = operand1 - operand2; break;
				case "*": res = operand1 * operand2; break;
				case "/": res = operand1 / operand2; break;
				default: res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		// FIX ME for possible variable names
		double res = Double.NaN;
		if (operand.matches(doubleExp())) {
			res = Double.parseDouble(operand);
		} else {
			if (names != null) {
				int index = Arrays.binarySearch(names, operand);
				if (index >= 0) {
					res = values[index];
				}
			}
			
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		// TO DO
		int countBraces = 0;
		int i = 0;
		int expressionLength = expression.length();
		while (i < expressionLength && countBraces >= 0) {
			switch (expression.charAt(i)) {
				case '(': countBraces++; break;
				case ')': countBraces--; break;
			}
			i++;
		}
		return countBraces == 0;
	}
}
