
public class Person {

	private String name;
	private int age;

	Person() {
		name = "Unknown";
		age = 18;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	Person(Person other) { // Copy Constructor
		this.name = other.name;
		this.age = other.age;
	}

	void display() {
		System.out.println("Person's Name: " + name);
		System.out.println("Person's Age: " + age);
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("Rishabh Gupta", 21);
		Person p3 = new Person(p2);
		p1.display();
		p2.display();
		p3.display();
	}

}
