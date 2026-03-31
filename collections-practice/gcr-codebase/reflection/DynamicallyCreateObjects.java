
class Student {
	public Student() {
		System.out.println("Student object created");
	}
}

public class DynamicallyCreateObjects {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("Student");

		Object obj = cls.getDeclaredConstructor().newInstance();

		System.out.println("Object type: " + obj.getClass().getName());
	}
}
