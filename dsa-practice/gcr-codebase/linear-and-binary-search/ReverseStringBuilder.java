public class ReverseStringBuilder {
	public static void main(String[] args) {
		String t = "hello";
		StringBuilder s = new StringBuilder(t);
		t = s.reverse().toString();
		System.out.println(t);
	}
}
