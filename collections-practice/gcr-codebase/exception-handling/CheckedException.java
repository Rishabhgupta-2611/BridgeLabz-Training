import java.io.*;

public class CheckedException {
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream("data.txt");

			int ch;
			while ((ch = f.read()) != -1) {
				System.out.print((char) ch);
			}

			f.close();

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
}
