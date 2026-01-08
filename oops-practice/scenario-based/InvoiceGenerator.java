public class InvoiceGenerator {

	static String[] parseInvoice(String input) {
		return input.split(",");
	}

	static int getTotalAmount(String[] tasks) {
		int total = 0;

		for (String task : tasks) {
			String[] parts = task.split("-");
			String amountPart = parts[1].trim().split(" ")[0];
			total += Integer.parseInt(amountPart);
		}
		return total;
	}

	public static void main(String[] args) {

		String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

		String[] tasks = parseInvoice(input);
		int totalAmount = getTotalAmount(tasks);

		System.out.println("Tasks:");
		for (String task : tasks) {
			System.out.println(task.trim());
		}

		System.out.println("Total Invoice Amount: " + totalAmount + " INR");
	}
}
