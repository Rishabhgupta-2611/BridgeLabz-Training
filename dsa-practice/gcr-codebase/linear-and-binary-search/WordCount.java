import java.io.BufferedReader;
import java.io.FileReader;

public class WordCount {
    public static void main(String[] args) throws Exception {
        String fileName = "src/input.txt";
        String target = "Rishabh";
        int count = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(target)) {
                    count++;
                }
            }
        }

        br.close();
        System.out.println(count);
    }
}
