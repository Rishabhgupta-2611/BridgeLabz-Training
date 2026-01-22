public class ComparisonString {
	public static void main(String[] args) {
		int n = 1000000;

		long startBuffer = System.nanoTime();
		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sbuf.append("hello");
		}
		long endBuffer = System.nanoTime();

		long startBuilder = System.nanoTime();
		StringBuilder sbui = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sbui.append("hello");
		}
		long endBuilder = System.nanoTime();

		System.out.println("StringBuffer Time (ns): " + (endBuffer - startBuffer));
		System.out.println("StringBuilder Time (ns): " + (endBuilder - startBuilder));
	}
}
