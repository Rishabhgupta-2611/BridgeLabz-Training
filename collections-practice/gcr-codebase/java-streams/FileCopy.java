import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {

		File sourceFile = new File("source.txt");
		File destinationFile = new File("destination.txt");

		if (!sourceFile.exists()) {
			System.out.println("Source file does not exist!");
			return;
		}

		try (FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(destinationFile)) {
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			System.out.println("File copied successfully!");
		} catch (IOException e) {
			System.out.println("Error occurred while copying the file.");
		}
	}
}
