package practice.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("Tesla", 5000000);

        String json = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(car);

        System.out.println(json);
    }
}
