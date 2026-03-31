import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderExample {
	public static void main(String[] args) {
		String fileName = "src/input.txt";

		try {
			FileInputStream fis = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			br.close();
			isr.close();
			fis.close();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
