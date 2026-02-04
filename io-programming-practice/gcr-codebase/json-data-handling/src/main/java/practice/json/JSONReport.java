package practice.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReport {

    public static void main(String[] args) throws Exception {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rahul", 50000));
        employees.add(new Employee(2, "Neha", 60000));
        employees.add(new Employee(3, "Aryan", 70000));

        // Convert records to JSON report
        ObjectMapper mapper = new ObjectMapper();

        String jsonReport = mapper.writerWithDefaultPrettyPrinter()
                                  .writeValueAsString(employees);

        // Print JSON report
        System.out.println(jsonReport);
    }
}
