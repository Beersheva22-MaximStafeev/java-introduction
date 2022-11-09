
public class IsraelIdentity {
	private static final int NUMBER_OF_DIGITS_IN_TZ = 9;

	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * control sum should be multiplied on 10 without remainder
	 * 
	 */
	
	public static int countCheckSum(int number) {
		int res = 0;
		int[] digits = Numbers.getDigits(number);
		for (int i = 0; i < digits.length; i += 2) {
			res += digits[i];
		}
		for (int i = 1; i < digits.length; i += 2) {
			int num = digits[i] * 2;
			res += num > 9 ? num % 10 + num / 10 : num;
		}
		return res;
	}
	
	
	/**
	 * 
	 * @return nuber of digits in TZ
	 * should by odd
	 * otherwise algorithm in generateRandomId should be changed a little to count 1-st digit, not the last one  
	 */
	public static int getNumDigitsInId() {
		return NUMBER_OF_DIGITS_IN_TZ;
	}
	
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * number 
	 * control sum should be multiple of 10  ( sum % 10 == 0)
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 7) digit = digit * 2, if > 9 the sum of inner digits is taken
	 * example, 123456782 => 1 + 4(2 * 2) + 3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) + 2
	 */
	public static boolean verify(int id) {
		boolean res = false; 
		if (Numbers.getNDigits(id) == getNumDigitsInId()) {
			res = countCheckSum(id) % 10 == 0;
		}
		return res;
	}
	
	/**
	 * 	
	 * @return random number of 9 digits matching right Israel id
	 * cycle not more than 9 iterations
	 */
	public static int generateRandomId() {
		int min = (int)Math.pow(10, getNumDigitsInId() - 2);
		int max = (int)Math.pow(10, getNumDigitsInId() - 1) - 1;
		int rnd = SportLotoAppl.getRandomInt(min, max);
		int checkSum = countCheckSum(rnd * 10);
		return rnd * 10 + (10 - checkSum % 10) % 10;
	}
	
}
