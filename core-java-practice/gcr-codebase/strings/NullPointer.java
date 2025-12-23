public class NullPointer {

	public static void handleException() {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception Handled");
		}
	}

	public static void main(String[] args) {
		String str = null;
		System.out.println(str.length());
		handleException();
	}
}
