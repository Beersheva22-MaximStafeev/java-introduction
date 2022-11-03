/**
 * 
 * @author Stafeev
 * right nBit value [0..63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
	private static final int N_BITS = 64;

	/**
	 * 
	 * @param nBit - bit number, passed in our methods 
	 * @return - test if bit number is correct - in the length of long
	 */
	static public boolean testNBit(int nBit) {
		return (nBit >=0) && (nBit < N_BITS);
	}
	
	/**
	 * some comments
	 * @param number any number
	 * @param nBit - number of bit to return it's value
	 * @return value of bit with number n 
	 */
	static public int getBitValue(long number, int nBit) {
		long res = -1;
		if (testNBit(nBit)) {
			long mask = getMask(nBit); 
			// long mask = (long)1 << nBit;
//			if ((number & mask) != 0) {
//				res = 1;
//			} else {
//				res = 0;
//			}
			// equivalent 
			res = (number & mask) != 0 ? 1 : 0; 
		}
		return (int) res;
	}

	private static long getMask(int nBit) {
		return 1L << nBit;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param value - true for 1, false for 0
	 * @return - number in witch value of nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (testNBit(nBit)) {
			long mask = getMask(nBit);
			res = value ? number | mask : number & ~mask;
//			if (value) {
//				res = number | mask;
//			} else {
//				res = number & (~mask);
//			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return - new number in which value of nBit bit will be inverted (0 -> 1, 1 -> 0)
	 */
	static public long invertBitValue(long number, int nBit) {
		long res = -1L;
		if (testNBit(nBit)) {
			long mask = getMask(nBit);
			res = number ^ mask;
			
			// var 1
//			res = (number & mask) == 0 ? number + mask : number - mask;
//			if ((number & mask) == 0) {
//				res = number + mask;
//			} else {
//				res = number - mask;
//			}
			// var 2
//			boolean newValue = getBitValue(number, nBit) == 0;
//			res = setBitValue(number, nBit, newValue);
		}
		return res;
	}
	
	// count leading zerrows
	/**
	 * 
	 * @param number - any long number
	 * @return - count leading bit-zeros
	 */
	static public int leadingZeros(long number) {
		//TO DO
		int counter = 0;
		int nBit = N_BITS - 1;
		while (nBit >=0 && getBitValue(number, nBit) == 0) {
			counter++;
			nBit--;
			// the same
			// nBit = nBit - 1;
			// nBit -= 1;
		}
		return counter;
	}
	
	// count bits 
	/**
	 * 
	 * @param number - any long number
	 * @return - count bit ones
	 */
	static public int onesInNumber(long number) {
		//TO DO
		//FIX ME
		int counter = 0;
		for (int nBit = N_BITS - 1 ; nBit >= 0 ; nBit--) {
			if (getBitValue(number, nBit) == 1) {
				counter++;
			}
		}
		return counter;
	}
	
	
}
