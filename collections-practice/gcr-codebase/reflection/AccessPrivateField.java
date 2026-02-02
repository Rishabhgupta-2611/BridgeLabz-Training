import java.lang.reflect.Field;

class Person {
	private int age = 25;
}

public class AccessPrivateField {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class<?> cls = p.getClass();
		
		Field field = cls.getDeclaredField("age");

		field.setAccessible(true); 
		field.setInt(p, 30); 

		int value = field.getInt(p);
		System.out.println("Age = " + value);
	}
}
