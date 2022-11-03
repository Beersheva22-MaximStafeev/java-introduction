/**
 * 
 * @author Stafeev
 *
 */
public class Numbers {
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
	 * @return - sum of last 3 digits
	 */
	static public int getSum3(int number) {
		int res = 0;
		for (int i = 1; i <= 3; i++) {
			res += number % 10;
			number = number / 10;
		}
		return res;
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
			res = getSum3(number) == getSum3(number / 1000);
		}
		return res;
	}
}

