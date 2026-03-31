import java.io.*;

public class InputStreamReaderToFile {
	public static void main(String[] args) {
		String fileName = "output.txt";

		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			FileWriter fw = new FileWriter(fileName);

			String input;
			System.out.println("Enter text (type 'exit' to stop):");

			while (true) {
				input = br.readLine();

				if (input.equalsIgnoreCase("exit")) {
					break;
				}

				fw.write(input + System.lineSeparator());
			}

			fw.close();
			br.close();

			System.out.println("Data successfully written to file.");

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
