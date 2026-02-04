package practice.json;
import java.io.*;
import com.fasterxml.jackson.databind.*;

public class ReadJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/java/practice/json/sample.json");
        JsonNode rootNode = mapper.readTree(file);

        String name = rootNode.get("name").asText();
        String email = rootNode.get("email").asText();

        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}
