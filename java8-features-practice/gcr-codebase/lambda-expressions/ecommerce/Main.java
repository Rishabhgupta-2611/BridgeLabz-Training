package ecommerce;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();

		products.add(new Product("Laptop", 60000, 4.5, 20));
		products.add(new Product("Mobile", 30000, 4.2, 30));
		products.add(new Product("Headphones", 3000, 4.8, 40));
		products.add(new Product("Smart Watch", 15000, 4.0, 25));

		products.sort((p1, p2) -> Double.compare(p1.price, p2.price));

		System.out.println("Sorted by Price:");
		products.forEach(System.out::println);

		products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));

		System.out.println("\nSorted by Rating:");
		products.forEach(System.out::println);

		products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));

		System.out.println("\nSorted by Discount:");
		products.forEach(System.out::println);
	}
}