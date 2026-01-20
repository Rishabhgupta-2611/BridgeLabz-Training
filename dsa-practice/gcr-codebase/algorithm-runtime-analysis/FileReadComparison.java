import java.io.*;

public class FileReadComparison {

	public static void main(String[] args) throws Exception {

		String filePath = "C:\\Users\\risha\\eclipse-workspace\\algorithm-runtime-analysis\\src\\largeFile_10MB.txt";

		char[] buffer = new char[8192];

		// FileReader
		long start = System.nanoTime();

		try (FileReader fr = new FileReader(filePath)) {
			while (fr.read(buffer) != -1) {
				// just reading
			}
		}

		long end = System.nanoTime();
		System.out.println("FileReader Time: " + (end - start) / 1_000_000 + " ms");

		// InputStreamReader
		start = System.nanoTime();

		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {

			while (isr.read(buffer) != -1) {
				// just reading
			}
		}

		end = System.nanoTime();
		System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000 + " ms");
	}
}
