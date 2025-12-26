
public class MatrixManipulationOperations {

	static int[][] randomMatrix(int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = (int) Math.random() * 100;
			}
		}
		return matrix;
	}

	static int[][] transpose(int[][] matrix, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = matrix[j][i];
			}
		}
		return matrix;
	}

	static int determinant(int[][] matrix,int 2) {
		return (matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]);

	}

	static int determinant3x3(int[][] matrix,int 3) {
		int a = matrix[0][0];
	    int b = matrix[0][1];
	    int c = matrix[0][2];

	    int d = matrix[1][0];
	    int e = matrix[1][1];
	    int f = matrix[1][2];

	    int g = matrix[2][0];
	    int h = matrix[2][1];
	    int i = matrix[2][2];

	    return a * (e * i - f * h)
	         - b * (d * i - f * g)
	         + c * (d * h - e * g);
	}

	public static void main(String[] args) {

	}

}
