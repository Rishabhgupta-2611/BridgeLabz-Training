package numberuppercasing;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		List<String> employees = Arrays.asList("Amit", "Rohit", "Sneha", "Priya");

		employees.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}
