import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		// use standard class Arrays, method copyOf
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[array.length] = number;
		return newArray;
	}
	
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array without number at given index
	 * if index doesn't exist in a given array, in returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
		// use standard class System, method arrayCopy
		int[] newArray;
		if ((index < 0) || (index >= array.length)) {
			newArray = array;
		} else {
			newArray = new int[array.length-1];
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index+1, newArray, index, array.length - index - 1);
		}
		return newArray;
	}
	
	private static int[] insertAtIndex(int[] array, int number, int index) {
		int res[] = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}
	
	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number, array should remain sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		// use the method binarySearch of standard class Arrays
		// use the method arrayCopy of the standard class System
		int[] newArray = new int[arraySorted.length + 1];
		int searchIndex = Arrays.binarySearch(arraySorted, number);
		int newIndex = searchIndex < 0 ? -searchIndex - 1 : searchIndex; 
		return insertAtIndex(arraySorted, number, newIndex);
	}
	
	/**
	 * 1.	Update method binarySearch in the class MyArrays such that 
	 * if a being searched number is encountered several times in a given sorted array 
	 * the method should return the first index value, 
	 * otherwise (no number in a given array) the method should return 
	 * the same negative value as the Java standard  Arrays.binarySearch does
	 * 1.1.	Complexity of the method should be O[LogN]
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise see previous comment 
	 * O[logN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[left] != number) {
			if (number <= arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		int res;
		if (left >= arraySorted.length) {
			res = -arraySorted.length - 1;
		} else {
			if (arraySorted[left] == number) {
				res = left;
			} else {
				res = -left - 1;
			}
		}
		return res;
	}
	
	/**
	 * swapping 2 elements in a given array
	 * @param array
	 * @param index1
	 * @param index2
	 */
	private static void swapElementsInArray(int[] array, int index1, int index2) {
		if (index1 >= 0 && index2 >= 0 && index1 < array.length && index2 < array.length) {
			int swap = array[index1];
			array[index1] = array[index2];
			array[index2] = swap;			
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @param swapLeft
	 * @param swapRight
	 * @param index
	 * @return return element from array from a given index, 
	 * 		but with swapped elements in positions swapLeft and swapRight 
	 */
	private static int getFromSwappedArray(int[] array, int swapLeft, int swapRight, int index) {
		int res = 0;
		if (index == swapLeft) {
			res = array[swapRight];
		} else if (index == swapRight) {
			res = array[swapLeft];
		} else {
			res = array[index];
		}
		return res;
	}
	
	/**
	 * 2.	Write method isOneSwapForSorted in the class MyArrays that takes an array 
	 * and returns true if the array is unsorted but only one swap between two numbers is required 
	 * for getting a sorted array.
	 * 2.1.	Given array shouldn’t be updated
	 * 2.2.	Complexity should be O[N]

	 * @param array
	 * @return
	 */	
	public static boolean isOneSwapForSorted(int[] array) {
		int l = 0;
		int r = array.length - 1;
		boolean res = false;
		int lEqualPos = 0;
		int rEqualPos = r;
		
		if (r > l) {
			while (l < r && array[l] <= array[l+1]) {
				if (array[l] < array[l+1]) { 
					lEqualPos = l + 1;
				}
				l++;
			}
			while (r > l && array[r-1] <= array[r]) {
				if (array[r-1] < array[r]) {
					rEqualPos = r - 1;
				}
				r--;
			}
			if (r > l) {
				r = rEqualPos;
				l = lEqualPos;
				if (r + 1 < array.length) r++;
				if (l > 0) l--;
				while (l < r && (getFromSwappedArray(array,rEqualPos,lEqualPos,l)  <= getFromSwappedArray(array,rEqualPos,lEqualPos,l+1))) {
					l++;
				}
				res = r == l;
			}
		}
		return res;
	}
	
	/**
	 *  3.	Write method bubbleSort in the class MyArrays
	 *  3.1.	Bubble sort implies repeated moving greater values toward the end of array until array is sorted. The moving is done by swapping between two adjacent array elements (i with i+1). Consider method swap
	 *  3.2.	Apply additional private method moveGreaterRight that in the cycle compares I-th element with I+1-th element and if I-th value greater than I+1-th one the swap is performed, thus it moves the greater value to right
	 *  3.3.	Requirements:
	 *  3.3.1.	Most effective algorithm in the class of algorithms O[N ^ 2]
	 *  3.3.2.	The minimal number of iterations (the array is already sorted) should be N
	 *  3.3.3.	The maximal number of iterations should be N * (N + 1) / 2 

	 */
	public static void bubbleSort(int[] array) {
		int i = 0; 
		boolean wasSwaps = true;
		while (i + 1 < array.length && wasSwaps) {
			wasSwaps = false;
			for (int j = 0; j + 1 < array.length - i; j++) {
				if (array[j+1] < array[j]) {
					wasSwaps = true;
					swapElementsInArray(array, j, j+1);
				}
			}
			i++;
		}
	}
	
	/**
	 * 
	 * @param array of short positive numbers
	 * @param sum - positive number
	 * @return true if array contains two numbers, sum of which equals a given sum
	 */
	static public boolean isSum2(short array[], int sum) {
		boolean[] sums = new boolean[sum];
		boolean res = false;
		int oposit;
		int i = 0;
		while (i < array.length && !res) {
			oposit = sum - array[i];
			if (oposit > 0 && oposit < sum) {
				res = sums[oposit];
				sums[array[i]] = true;
			}
			i++;
		}
		return res;
	}
}
