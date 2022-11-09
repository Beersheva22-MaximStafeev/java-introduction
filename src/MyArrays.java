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
		System.arraycopy(arraySorted, 0, newArray, 0, newIndex);
		newArray[newIndex] = number;
		System.arraycopy(arraySorted, newIndex, newArray, newIndex + 1, arraySorted.length - (newIndex));
		return newArray;
	}
}
