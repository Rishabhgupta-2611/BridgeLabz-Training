import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceComparison {

	public static void main(String[] args) throws Exception {

		int iterations = 1_000_000;
		String text = "hello";

		long start, end;

		// StringBuilder
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < iterations; i++) {
			sb.append(text);
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder Time: " + (end - start) + " ms");

		// StringBuffer
		start = System.currentTimeMillis();
		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < iterations; i++) {
			sbuf.append(text);
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer Time: " + (end - start) + " ms");

		String filePath = "src/input.txt";

		// FileReader
		start = System.currentTimeMillis();
		int wordCountFR = countWordsUsingFileReader(filePath);
		end = System.currentTimeMillis();
		System.out.println("FileReader Word Count: " + wordCountFR);
		System.out.println("FileReader Time: " + (end - start) + " ms");

		// InputStreamReader
		start = System.currentTimeMillis();
		int wordCountISR = countWordsUsingInputStreamReader(filePath);
		end = System.currentTimeMillis();
		System.out.println("InputStreamReader Word Count: " + wordCountISR);
		System.out.println("InputStreamReader Time: " + (end - start) + " ms");
	}

	static int countWordsUsingFileReader(String path) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(path));
		int count = 0;
		String line;

		while ((line = br.readLine()) != null) {
			count += line.trim().split("\\s+").length;
		}

		br.close();
		return count;
	}

	static int countWordsUsingInputStreamReader(String path) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
		int count = 0;
		String line;

		while ((line = br.readLine()) != null) {
			count += line.trim().split("\\s+").length;
		}

		br.close();
		return count;
	}
}
