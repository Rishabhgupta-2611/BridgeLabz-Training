
class TextState {
	String content;
	TextState prev;
	TextState next;

	TextState(String content) {
		this.content = content;
		this.prev = null;
		this.next = null;
	}
}

class UndoRedoManager {
	TextState head;
	TextState tail;
	TextState current;
	int size = 0;
	final int MAX_SIZE = 10;

	void addState(String text) {
		TextState newState = new TextState(text);

		if (current != null && current.next != null) {
			current.next.prev = null;
			current.next = null;
			tail = current;
		}

		if (head == null) {
			head = tail = current = newState;
			size = 1;
			return;
		}

		tail.next = newState;
		newState.prev = tail;
		tail = newState;
		current = newState;
		size++;

		if (size > MAX_SIZE) {
			head = head.next;
			head.prev = null;
			size--;
		}
	}

	void undo() {
		if (current != null && current.prev != null) {
			current = current.prev;
		} else {
			System.out.println("Nothing to undo");
		}
	}

	void redo() {
		if (current != null && current.next != null) {
			current = current.next;
		} else {
			System.out.println("Nothing to redo");
		}
	}

	void displayCurrent() {
		if (current == null) {
			System.out.println("Editor empty");
		} else {
			System.out.println("Current Text: " + current.content);
		}
	}
}

public class UndoRedoFunctionality {
	public static void main(String[] args) {

		UndoRedoManager editor = new UndoRedoManager();

		editor.addState("Hello");
		editor.addState("Hello World");
		editor.addState("Hello World!");
		editor.displayCurrent();

		System.out.println("Undo:");
		editor.undo();
		editor.displayCurrent();

		System.out.println("Redo:");
		editor.redo();
		editor.displayCurrent();

		System.out.println("Add new text:");
		editor.addState("Hello World!!");
		editor.displayCurrent();
	}
}
