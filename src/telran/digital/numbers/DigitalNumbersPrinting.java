package telran.digital.numbers;

public class DigitalNumbersPrinting {
	private static final String SPACE = " ";
	private static final String SYMBOL = "*";
	private static final int INTERVAL = 2;
	private static final boolean DIGITAL = false;
	
	public static void displayDigitalNumber(int number, int offcet, int width, int height) {
		if (width > 0 && height > 0) {
			String[][] allDigits;
			if (DIGITAL) {
				allDigits = getAllDigitsDigital(width, height);
			} else {
				allDigits = getAllDigitsPochta(width, height);
			}
			String[] interval = getEmptyDigit(INTERVAL, height);
			String[] res = getEmptyDigit(0, height);
			do {
				res = digitalPrintingConcat(digitalPrintingConcat(allDigits[number % 10], interval), res);
				number /= 10;
			} while (number > 0);
			res = digitalPrintingConcat(getEmptyDigit(offcet, height), res);
			displayStrings(res);
		}
	}
	
	private static String[][] getAllDigitsPochta(int width, int height) {
		String[][] allDigits = new String[10][];
		for (int i = 0; i < 10; i++) {
			switch (i) {
				case 0: allDigits[i] = digit0(width, height); break;
				case 1: allDigits[i] = digit1Pochta(width, height); break;
				case 2: allDigits[i] = digit2Pochta(width, height); break;
				case 3: allDigits[i] = digit3Pochta(width, height); break;
				case 4: allDigits[i] = digit4(width, height); break;
				case 5: allDigits[i] = digit5(width, height); break;
				case 6: allDigits[i] = digit6(width, height); break;
				case 7: allDigits[i] = digit7Pochta(width, height); break;
				case 8: allDigits[i] = digit8(width, height); break;
				case 9: allDigits[i] = digit9Pochta(width, height); break;
			}
		}
		return allDigits;
	}

	private static String[][] getAllDigitsDigital(int width, int height) {
		String[][] allDigits = new String[10][];
		for (int i = 0; i < 10; i++) {
			switch (i) {
				case 0: allDigits[i] = digit0(width, height); break;
				case 1: allDigits[i] = digit1(width, height); break;
				case 2: allDigits[i] = digit2(width, height); break;
				case 3: allDigits[i] = digit3(width, height); break;
				case 4: allDigits[i] = digit4(width, height); break;
				case 5: allDigits[i] = digit5(width, height); break;
				case 6: allDigits[i] = digit6(width, height); break;
				case 7: allDigits[i] = digit7(width, height); break;
				case 8: allDigits[i] = digit8(width, height); break;
				case 9: allDigits[i] = digit9(width, height); break;
			}
		}
		return allDigits;
	}

	private static String[] digitalPrintingConcat(String[] left, String[] right) {
		String[] res = new String[left.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = left[i] + right[i];
		}
		return res;
	}
	/**
	 * 
	 * @param offset
	 * @param length
	 * @return one line from offset 
	 */
	public static String line(int offset, int length) {
		return SPACE.repeat(offset) + SYMBOL.repeat(length);
	}
	
	public static String[] verticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = line(offset, 1);
		}
		return res;
	}
	
	public static String[] twoVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = line(offset, 1) + line(width > 1?width - 2:0, 1);
		}
		return res;
	}

	public static void displayStrings(String[] verticalLine) {
		for (int i = 0; i < verticalLine.length; i++) {
			System.out.println(verticalLine[i]);
		}
		
	}
	
	public static void drawLine(String[] digit, int col1, int row1, int col2, int row2) {
		int deltaRow = Math.abs(row1 - row2);
		int deltaCol = Math.abs(col1 - col2);
		if (deltaRow > deltaCol) {
			int curRow = row1;
			int incRow = row2 - row1 > 0? 1 : -1;
			while (curRow - row2 != incRow) {
				int curCol = col1 + (col2-col1)*(curRow-row1)/(row2-row1);
				printSymbol(digit, curRow, curCol);
				curRow = curRow + incRow;
			}
		} else if (deltaCol == 0) {
			printSymbol(digit, row1, col1);
		} else {
			int curCol = col1;
			int incCol = col2 - col1 > 0? 1 : -1;
			while (curCol - col2 != incCol) {
				int curRow = row1 + (row2-row1)*(curCol-col1)/(col2-col1);
				printSymbol(digit, curRow, curCol);
				curCol = curCol + incCol;
			}
		}

	}
	
	public static String[] getEmptyDigit(int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = SPACE.repeat(width);
		}
		return res;
	}

	private static void printSymbol(String[] digit, int curRow, int curCol) {
		digit[curRow] = digit[curRow].substring(0, curCol) + SYMBOL + digit[curRow].substring(curCol + 1);
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLine(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] =  line(offset, width);
		return res;
	}
	
	public static String[] one(int offset, int width, int height) {
		String[] res = new String[height];
		res = verticalLine(offset + width - 1, height);
		return res;
	}
	
	public static String[] digit0(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width - 1, 0);
		drawLine(res, 0, 0, 0, height - 1);
		drawLine(res, width - 1, 0, width - 1, height - 1);
		drawLine(res, 0, height - 1, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit1(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res,  width - 1, 0, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit1Pochta(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, height / 2,  width - 1, 0);
		drawLine(res,  width - 1, 0, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit2(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, width - 1, 0, width - 1, height / 2);
		drawLine(res, width - 1, height / 2, 0, height / 2);
		drawLine(res, 0, height / 2, 0, height - 1);
		drawLine(res, 0, height - 1, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit2Pochta(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, width - 1, 0, width - 1, height / 2);
		drawLine(res, width - 1, height / 2, 0, height - 1);
		drawLine(res, 0, height - 1, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit3(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, 0, height / 2, width-1, height / 2);
		drawLine(res, 0, height - 1, width-1, height - 1);
		drawLine(res, width-1, 0, width-1, height - 1);
		return res;
	}
	
	public static String[] digit3Pochta(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, width-1, 0, 0, height / 2);
		drawLine(res, 0, height / 2, width-1, height / 2);
		drawLine(res, width-1, height / 2, 0, height - 1);
		return res;
	}
	
	public static String[] digit4(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, 0, height / 2);
		drawLine(res, 0, height / 2, width - 1, height / 2);
		drawLine(res, width - 1, 0, width-1, height - 1);
		return res;
	}
	
	public static String[] digit5(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, width-1, 0, 0, 0);
		drawLine(res, 0, 0, 0, height / 2);
		drawLine(res, 0, height / 2, width - 1, height / 2);
		drawLine(res, width - 1, height / 2, width - 1, height - 1);
		drawLine(res, width - 1, height - 1, 0, height - 1);
		return res;
	}
	
	public static String[] digit6(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, width-1, 0, 0, 0);
		drawLine(res, 0, 0, 0, height - 1);
		drawLine(res, 0, height / 2, width - 1, height / 2);
		drawLine(res, width - 1, height / 2, width - 1, height - 1);
		drawLine(res, width - 1, height - 1, 0, height - 1);
		return res;
	}
	
	public static String[] digit7(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, width-1, 0, width-1, height - 1);
		return res;
	}
	
	public static String[] digit7Pochta(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, width-1, 0, 0, height / 2);
		drawLine(res, 0, height / 2, 0, height - 1);
		return res;
	}
	
	public static String[] digit8(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, 0, height / 2, width-1, height / 2);
		drawLine(res, 0, height - 1, width-1, height - 1);
		drawLine(res, 0, 0, 0, height - 1);
		drawLine(res, width - 1, 0, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit9(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, 0, height / 2, width-1, height / 2);
		drawLine(res, 0, height - 1, width-1, height - 1);
		drawLine(res, 0, 0, 0, height / 2);
		drawLine(res, width - 1, 0, width - 1, height - 1);
		return res;
	}
	
	public static String[] digit9Pochta(int width, int height) {
		String[] res = getEmptyDigit(width, height);
		drawLine(res, 0, 0, width-1, 0);
		drawLine(res, 0, height / 2, width-1, height / 2);
		drawLine(res, 0, 0, 0, height / 2);
		drawLine(res, width - 1, 0, width - 1, height / 2);
		drawLine(res, width - 1, height / 2, 0, height - 1);
		return res;
	}
	
}
