
public class OverLoading {

	int exam(int a) {
		return a;
	}

	int exam(int a, int b) {
		return a + b;
	}

	double exam(double a, double b, double c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		OverLoading k = new OverLoading();
		System.out.println(k.exam(5));
		System.out.println(k.exam(4, 2));
		System.out.println(k.exam(4.2, 4.1, 8.2));
	}

}
