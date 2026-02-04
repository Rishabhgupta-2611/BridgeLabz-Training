package practice.json;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListToJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 6000000));
        cars.add(new Car("Audi", 7000000));
        cars.add(new Car("Tesla", 5000000));

        String jsonArray = mapper.writerWithDefaultPrettyPrinter()
                                 .writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}
