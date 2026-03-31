
public class MatrixOperations {

	public static int[][] createRandomMatrix(int rows, int cols) {
		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = (int) (Math.random() * 10);

		return matrix;
	}

	public static int[][] addMatrices(int[][] A, int[][] B) {
		int[][] result = new int[A.length][A[0].length];

		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				result[i][j] = A[i][j] + B[i][j];

		return result;
	}

	public static int[][] subtractMatrices(int[][] A, int[][] B) {
		int[][] result = new int[A.length][A[0].length];

		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				result[i][j] = A[i][j] - B[i][j];

		return result;
	}

	public static int[][] multiplyMatrices(int[][] A, int[][] B) {
		int[][] result = new int[A.length][B[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return result;
	}

	public static void displayMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int value : row)
				System.out.print(value + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int rows = 2, cols = 2;

		int[][] A = createRandomMatrix(rows, cols);
		int[][] B = createRandomMatrix(rows, cols);

		System.out.println("Matrix A:");
		displayMatrix(A);

		System.out.println("Matrix B:");
		displayMatrix(B);

		System.out.println("Addition:");
		displayMatrix(addMatrices(A, B));

		System.out.println("Subtraction:");
		displayMatrix(subtractMatrices(A, B));

		System.out.println("Multiplication:");
		displayMatrix(multiplyMatrices(A, B));
	}
}
