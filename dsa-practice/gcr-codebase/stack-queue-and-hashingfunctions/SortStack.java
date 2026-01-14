import java.util.Stack;

public class SortStack {

	static void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sortStack(stack);
			insertSorted(stack, temp);
		}
	}

	static void insertSorted(Stack<Integer> stack, int element) {
		if (stack.isEmpty() || stack.peek() <= element) {
			stack.push(element);
			return;
		}

		int temp = stack.pop();
		insertSorted(stack, element);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);

		sortStack(stack);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
