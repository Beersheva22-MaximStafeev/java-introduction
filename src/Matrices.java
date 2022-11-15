
public class Matrices {
	/**
	 * 
	 * @param rows
	 * @param columns
	 * @param minValue
	 * @param maxValue
	 * @return make and fill matrix [rows*columns] with random values from minValue to maxValue
	 */
	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int[][] res = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) Numbers.getRandomNumber(minValue, maxValue);
			}
		}
		return res;
	}
	
	public static int[][] transp(int [][] matrix) {
		int [][] res;
		if (matrix.length == 0) {
			res = new int[0][0];
		} else {
			res = new int[matrix[0].length][matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					res[j][i] = matrix[i][j];
				}
			}
		}
		return res;
	}
}
