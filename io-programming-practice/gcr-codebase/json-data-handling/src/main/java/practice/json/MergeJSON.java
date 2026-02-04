package practice.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        
        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Aryan");
        json1.put("age", 22);

        ObjectNode json2 = mapper.createObjectNode();
        json2.put("email", "aryan@gmail.com");
        json2.put("city", "Jalaun");

        json1.setAll(json2);

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValueAsString(json1)
        );
    }
}
