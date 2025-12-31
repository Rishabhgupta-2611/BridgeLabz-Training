
public class Circle {

	private double radius;

	Circle() { // Default Constructors
		radius = 0.0;
		System.out.printf("Radius of Circle: %.4f\n", radius);
	}

	Circle(double radius) { // Parameterized Constructors
		this.radius = radius;
		System.out.printf("Radius of Circle: %.4f\n", radius);
	}

	public static void main(String[] args) {
		new Circle();
		new Circle(4.0);

	}

}
