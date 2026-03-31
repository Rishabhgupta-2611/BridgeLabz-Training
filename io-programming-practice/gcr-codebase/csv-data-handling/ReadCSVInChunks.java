import java.io.*;

public class ReadCSVInChunks {

	public static void main(String[] args) {

		String filePath = "large.csv";
		int batchSize = 100;
		int totalCount = 0;
		int batchCount = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;
			br.readLine();

			while ((line = br.readLine()) != null) {

				batchCount++;
				totalCount++;

				if (batchCount >= batchSize) {
					System.out.println("Processed records so far: " + totalCount);
					batchCount = 0;
				}
			}

			if (batchCount > 0) {
				System.out.println("Processed records so far: " + totalCount);
			}

			System.out.println("Total records processed: " + totalCount);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
