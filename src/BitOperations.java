/**
 * 
 * @author Stafeev
 * right nBit value [0..63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
	/**
	 * 
	 * @param nBit - bit number, passed in our methods 
	 * @return - test if bit number is correct - in the length of long
	 */
	static public boolean testNBit(int nBit) {
		return (nBit >=0) && (nBit <= 63);
	}
	
	/**
	 * 
	 * @param number any number
	 * @param n8bit
	 * @return value of bit with number n 
	 */
	static public int getBitValue(long number, int nBit) {
		long res = -1;
		if (testNBit(nBit)) {
			long mask = 1 << nBit; 
			if ((number & mask) != 0) {
				res = 1;
			} else {
				res = 0;
			}
		}
		return (int) res;
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
			long mask = 1 << nBit;
			if (getBitValue(number, nBit) > 0) {
				if (value) {
					res = number;
				} else {
					res = number & (~mask);
				}
			} else {
				if (value) {
					res = number | mask;
				} else {
					res = number;
				}
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return - new number in which value of nBit bit will be reverted (0 -> 1, 1 -> 0)
	 */
	static public long revertBitValue(long number, int nBit) {
		long res = -1;
		if (testNBit(nBit)) {
			boolean newValue = getBitValue(number, nBit) == 0;
			res = setBitValue(number, nBit, newValue);
		}
		return res;
	}
	
	static public long pow2(int pow) {
//		long res = 1;
//		while (pow > 0) {
//			res = res * 2;
//			pow--;
//		}
//		return res;
		return 1 << pow;
	}
	
}
