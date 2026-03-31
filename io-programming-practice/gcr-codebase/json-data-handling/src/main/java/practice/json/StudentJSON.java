package practice.json;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentJSON {

    public static void main(String[] args) throws Exception {

    	ObjectMapper mapper = new ObjectMapper();
    	
    	Map<String, Object> student = new LinkedHashMap<>();
    	student.put("name", "Aryan");
    	student.put("age", 22);
    	student.put("subjects", List.of("Java", "DBMS", "OS"));

    	String json = mapper.writerWithDefaultPrettyPrinter()
		          .writeValueAsString(student);
    	
        System.out.println(json);
    }
}
