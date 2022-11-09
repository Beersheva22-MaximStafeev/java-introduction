/**
 * 
 * @author Stafeev
 *
 */
public class Numbers {
	private static final int NUMBER_OF_DIGITS = 6;
	/**
	 * 
	 * @param number - any long number
	 * @return - count of digits in number
	 */
	static public int getNDigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}
	
	// true - если это 6ти значное число и сумма первых 3х цифр = сумме последних 3х цифр
	/**
	 * 
	 * @param number - any number
	 * @param digitsCount - count of digits to sum from most right
	 * @return - sum of last 3 digits
	 */
	static public int getSumOfLastDigits(int number, int digitsCount) {
		int res = 0;
		for (int i = 1; i <= digitsCount; i++) {
			res += number % 10;
			number = number / 10;
		}
		return res;
	}
	
	static public int getSumDigits(int number) {
		int res = 0;
		do {
			res += number % 10;
			number /= 10;
		} while (number != 0);
		return res;
	}
	
	static public boolean isHappyNumberGood(int number) {
		boolean res = false;
		int NDigits = getNumbersToCount(); 
		int halfDigits = NDigits / 2;
		int border = (int) Math.pow(10, halfDigits);
		if (getNDigits(number) == NDigits) {
			res = getSumDigits( (number / border) % border) == getSumDigits(number % border);
		}
		return res;
	}
	
	private static int getNumbersToCount() {
		return NUMBER_OF_DIGITS;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number contains 6 digits and
	 * sum of first 3 digits equals to sum of last 3 digits
	 */
	static public boolean isHappyNumber(int number) {
		boolean res = false; 
		if (number >= 100000 && number <= 999999) {
			res = getSumOfLastDigits(number, 3) == getSumOfLastDigits(number / 1000, 3);
		}
		return res;
	}
	
	static public int[] getDigits(int number) {
		int[] res = new int[getNDigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
//		int i = 0;
//		do {
//			res[res.length -1 - i++] = number % 10;
//			number /= 10;
//		} while (number != 0);
		return res;
	}
	
	static public int getNumberFromDigits(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
}

