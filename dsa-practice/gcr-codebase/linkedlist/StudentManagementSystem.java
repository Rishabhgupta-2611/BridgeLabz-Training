
class StudentNode {
	int roll;
	String name;
	int age;
	char grade;
	StudentNode next;

	StudentNode(int roll, String name, int age, char grade) {
		this.roll = roll;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentLinkedList {
	StudentNode head;

	public void addAtBeginning(int roll, String name, int age, char grade) {
		StudentNode node = new StudentNode(roll, name, age, grade);
		node.next = head;
		head = node;
	}

	public void addAtEnd(int roll, String name, int age, char grade) {
		StudentNode node = new StudentNode(roll, name, age, grade);

		if (head == null) {
			head = node;
			return;
		}

		StudentNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	// Add at specific position
	public void addAtPosition(int position, int roll, String name, int age, char grade) {
		if (position == 1) {
			addAtBeginning(roll, name, age, grade);
			return;
		}

		StudentNode node = new StudentNode(roll, name, age, grade);
		StudentNode temp = head;

		for (int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Invalid position!");
			return;
		}

		node.next = temp.next;
		temp.next = node;
	}

	public void deleteByRoll(int roll) {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}

		if (head.roll == roll) {
			head = head.next;
			System.out.println("Student deleted successfully");
			return;
		}

		StudentNode temp = head;
		while (temp.next != null && temp.next.roll != roll) {
			temp = temp.next;
		}

		if (temp.next == null) {
			System.out.println("Student not found!");
		} else {
			temp.next = temp.next.next;
			System.out.println("Student deleted successfully");
		}
	}

	public void searchByRoll(int roll) {
		StudentNode temp = head;

		while (temp != null) {
			if (temp.roll == roll) {
				System.out.println("Student Found:");
				System.out.println("Roll: " + temp.roll);
				System.out.println("Name: " + temp.name);
				System.out.println("Age: " + temp.age);
				System.out.println("Grade: " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found!");
	}

	public void updateGrade(int roll, char newGrade) {
		StudentNode temp = head;

		while (temp != null) {
			if (temp.roll == roll) {
				temp.grade = newGrade;
				System.out.println("Grade updated successfully");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found!");
	}

	public void display() {
		if (head == null) {
			System.out.println("No student records available");
			return;
		}

		StudentNode temp = head;
		while (temp != null) {
			System.out.println(
					"Roll: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
			temp = temp.next;
		}
	}
}

public class StudentManagementSystem {
	public static void main(String[] args) {

		StudentLinkedList list = new StudentLinkedList();

		list.addAtBeginning(1, "Aryan", 20, 'A');
		list.addAtEnd(2, "Pankaj", 21, 'B');
		list.addAtPosition(2, 3, "Sarthak", 19, 'A');

		System.out.println("All Students:");
		list.display();

		System.out.println("\nSearch Student:");
		list.searchByRoll(2);

		System.out.println("\nUpdate Grade:");
		list.updateGrade(3, 'A');

		System.out.println("\nDelete Student:");
		list.deleteByRoll(1);

		System.out.println("\nFinal List:");
		list.display();
	}
}