class Animal {
	String name;
	int age;

	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void makeSound() {
		System.out.println("Animal makes a sound");
	}
}

class Dog extends Animal {
	Dog(String name, int age) {
		super(name, age);
	}

	void makeSound() {
		System.out.println("Dog barks");
	}
}

class Cat extends Animal {
	Cat(String name, int age) {
		super(name, age);
	}

	void makeSound() {
		System.out.println("Cat meows");
	}
}

class Bird extends Animal {
	Bird(String name, int age) {
		super(name, age);
	}

	void makeSound() {
		System.out.println("Bird chirps");
	}
}

public class AnimalHierarchy {

	public static void main(String[] args) {
		Animal a1 = new Dog("LUNA", 6);
		Animal a2 = new Cat("NOVA", 4);
		Animal a3 = new Bird("SKY", 2);
		a1.makeSound();
		a2.makeSound();
		a3.makeSound();

	}

}
