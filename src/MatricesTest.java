import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MatricesTest {
	@Test
	void transpTest() {
		// tests
		int[][][][] tests = {
			{
				{
					{1,2},
					{3,4},
					{5,6}
				},
				{
					{1,3,5},
					{2,4,6}
				}
			},
			{
				{
					{1,2,3}
				},
				{
					{1},
					{2},
					{3}
				}
			}
		};
		for (int i = 0; i < tests.length; i++) {
			assertArrayEquals(tests[i][0], Matrices.transp(tests[i][1]));
			assertArrayEquals(tests[i][1], Matrices.transp(tests[i][0]));
		}
	}
}
