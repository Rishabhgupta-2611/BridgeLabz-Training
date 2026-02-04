package practice.json;
import java.io.File;
import java.util.Set;
import com.fasterxml.jackson.databind.*;
import com.networknt.schema.*;

public class EmailValidation {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Read JSON data
        JsonNode jsonData = mapper.readTree(new File("src/main/java/practice/json/user.json"));

        // Read JSON schema
        JsonNode schemaNode = mapper.readTree(new File("src/main/java/practice/json/schema.json"));

        // Create schema validator
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaNode);

        // Validate
        Set<ValidationMessage> errors = schema.validate(jsonData);

        if (errors.isEmpty()) {
            System.out.println("Email is VALID");
        } else {
            System.out.println("Email is INVALID");
            errors.forEach(e -> System.out.println(e.getMessage()));
        }
    }
}
