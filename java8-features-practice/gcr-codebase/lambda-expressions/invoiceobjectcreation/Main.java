package invoiceobjectcreation;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<Integer> transactionIds = Arrays.asList(501, 502, 503, 504);
		List<Invoice> invoices = transactionIds.stream().map(Invoice::new).collect(Collectors.toList());

		invoices.forEach(System.out::println);
	}
}
