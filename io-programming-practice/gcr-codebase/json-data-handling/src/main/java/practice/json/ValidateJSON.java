package practice.json;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ValidateJSON {

    public static void main(String[] args) {
    	
        String json = "{ \"name\": \"Aryan\", \"age\": 22 }";
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readTree(json);
            System.out.println("JSON is VALID");
        } 
        catch (Exception e) {
            System.out.println("JSON is INVALID");
        }
    }
}
