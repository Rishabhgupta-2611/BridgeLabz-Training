
class TaskNode {
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	TaskNode next;

	TaskNode(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
		this.next = null;
	}
}

class CircularTaskList {
	TaskNode head;
	TaskNode current;

	void addAtBeginning(int id, String name, int priority, String dueDate) {
		TaskNode newNode = new TaskNode(id, name, priority, dueDate);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
			return;
		}

		TaskNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		newNode.next = head;
		temp.next = newNode;
		head = newNode;
	}

	void addAtEnd(int id, String name, int priority, String dueDate) {
		TaskNode newNode = new TaskNode(id, name, priority, dueDate);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
			return;
		}

		TaskNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = head;
	}

	void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
		if (pos == 1) {
			addAtBeginning(id, name, priority, dueDate);
			return;
		}

		TaskNode temp = head;
		for (int i = 1; i < pos - 1 && temp.next != head; i++) {
			temp = temp.next;
		}

		TaskNode newNode = new TaskNode(id, name, priority, dueDate);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	void removeById(int id) {
		if (head == null) {
			System.out.println("No tasks available");
			return;
		}

		TaskNode temp = head;
		TaskNode prev = null;

		do {
			if (temp.taskId == id) {

				if (temp == head) {
					TaskNode last = head;
					while (last.next != head) {
						last = last.next;
					}

					head = head.next;
					last.next = head;
				} else {
					prev.next = temp.next;
				}

				System.out.println("Task removed successfully");
				return;
			}

			prev = temp;
			temp = temp.next;
		} while (temp != head);

		System.out.println("Task not found");
	}

	void viewNextTask() {
		if (current == null) {
			System.out.println("No tasks available");
			return;
		}

		displayTask(current);
		current = current.next;
	}

	void displayAll() {
		if (head == null) {
			System.out.println("No tasks to display");
			return;
		}

		TaskNode temp = head;
		do {
			displayTask(temp);
			temp = temp.next;
		} while (temp != head);
	}

	void searchByPriority(int priority) {
		if (head == null) {
			System.out.println("No tasks available");
			return;
		}

		TaskNode temp = head;
		boolean found = false;

		do {
			if (temp.priority == priority) {
				displayTask(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);

		if (!found)
			System.out.println("No task found with this priority");
	}

	// Helper method
	void displayTask(TaskNode t) {
		System.out.println(
				"ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due Date: " + t.dueDate);
	}
}

public class TaskScheduler {
	public static void main(String[] args) {

		CircularTaskList list = new CircularTaskList();

		list.addAtBeginning(1, "Assignment", 1, "10-10-2025");
		list.addAtEnd(2, "Project", 2, "15-10-2025");
		list.addAtEnd(3, "Presentation", 1, "12-10-2025");

		System.out.println("All Tasks:");
		list.displayAll();

		System.out.println("View Next Task:");
		list.viewNextTask();
		list.viewNextTask();

		System.out.println("Search by Priority:");
		list.searchByPriority(1);

		System.out.println("Remove Task:");
		list.removeById(2);

		System.out.println("Final Task List:");
		list.displayAll();
	}
}
