package practice.json;
import java.io.File;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode users = (ArrayNode) mapper.readTree(new File("src/main/java/practice/json/user.json"));

        for (JsonNode user : users) {
            int age = user.get("age").asInt();

            if (age > 25) {
                String name = user.get("name").asText();
                String email = user.get("email").asText();

                System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
            }
        }
    }
}
