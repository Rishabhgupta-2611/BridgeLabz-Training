
public class StringConcatenationComparison {

	public static void main(String[] args) {

		int[] sizes = { 1000, 10000, 1000000 };

		for (int n : sizes) {
			// Using String
			long start = System.nanoTime();
			String s = "";
			for (int i = 0; i < n; i++) {
				s += "a";
			}
			long end = System.nanoTime();
			System.out.println("String (" + n + "): " + (end - start) / 1_000_000 + " ms");

			// Using StringBuilder
			start = System.nanoTime();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append("a");
			}
			end = System.nanoTime();
			System.out.println("StringBuilder (" + n + "): " + (end - start) / 1_000_000 + " ms");

			// Using StringBuffer
			start = System.nanoTime();
			StringBuffer sbuf = new StringBuffer();
			for (int i = 0; i < n; i++) {
				sbuf.append("a");
			}
			end = System.nanoTime();
			System.out.println("StringBuffer (" + n + "): " + (end - start) / 1_000_000 + " ms");

			System.out.println("-----------------------------------");
		}
	}
}
