// Домашнее задание - сделать аппликацию, которая печатает 6 случайных чисел от 1..49
// числа не должны повторяться

public class SportLotoAppl {

	private static final boolean DEBUG_OUTPUT = false;

	/**
	 * 
	 * @param min - int
	 * @param max - int
	 * @return - return random int [min..max]
	 */
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (1+ max - min));
	}
	
	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 */
	public static void main(String[] args) {
//		int i1, i2, i3, i4, i5, i6;
//		i1 = -1;
//		i2 = -1;
//		i3 = -1;
//		i4 = -1;
//		i5 = -1;
//		i6 = -1;
		
//		i1 = getRandomInt(1,49);
//		do {
//			if (i2 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate i2: " + i2);
//			i2 = getRandomInt(1,49); 
//		} while (i2 == i1);
//		do {
//			if (i3 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate i3: " + i3);
//			i3 = getRandomInt(1,49);
//		} while (i3 == i1 || i3 == i2);
//		do {
//			if (i4 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate i4: " + i4);
//			i4 = getRandomInt(1,49); 
//		} while (i4 == i1 || i4 == i2 || i4 == i3);
//		do {
//			if (i5 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate i5: " + i5);
//			i5 = getRandomInt(1,49); 
//		} while (i5 == i1 || i5 == i2 || i5 == i3 || i5 == i4);
//		do {
//			if (i6 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate i6: " + i6);
//			i6 = getRandomInt(1,49); 
//		} while (i6 == i1 || i6 == i2 || i6 == i3 || i6 == i4 || i6 == i5);
//		do {
//			if (i1 != -1 && DEBUG_OUTPUT) System.out.println("Duplicate");
//			i1 = getRandomInt(1,49);
//			i2 = getRandomInt(1,49);
//			i3 = getRandomInt(1,49);
//			i4 = getRandomInt(1,49);
//			i5 = getRandomInt(1,49);
//			i6 = getRandomInt(1,49);
//		} while (i1 == i2 || i1 == i3 || i1 == i4 || i1 == i5 || i1 == i6 || 
//				i2 == i3 || i2 == i4 || i2 == i5 || i2 == i6 ||
//				i3 == i4 || i3 == i5 || i3 == i6 ||
//				i4 == i5 || i4 == i6 ||
//				i5 == i6);
//		
//		
//		System.out.print("" + i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + i6);
		long array = 0;
		int rnd;
		if (DEBUG_OUTPUT) System.out.println("Start");
		for (int i = 0; i < 6; i++) {
			do {
				rnd = getRandomInt(1, 49);
				if (DEBUG_OUTPUT) if (BitOperations.getBitValue(array, rnd) == 1) System.out.print("dup(" + rnd + ") ");  
			} while (BitOperations.getBitValue(array, rnd) == 0);
			array = BitOperations.setBitValue(array, rnd, true);
			System.out.print("" + rnd + " ");
		}
		if (DEBUG_OUTPUT) { System.out.println(""); System.out.println("Stop"); }
	}

}
