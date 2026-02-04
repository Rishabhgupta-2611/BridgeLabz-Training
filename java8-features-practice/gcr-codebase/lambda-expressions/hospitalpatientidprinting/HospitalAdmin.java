package hospitalpatientidprinting;

import java.util.*;

public class HospitalAdmin {
	public static void main(String[] args) {

		List<Patient> patients = Arrays.asList(new Patient(101), new Patient(102), new Patient(103), new Patient(104));

		patients.stream().map(Patient::getId).forEach(System.out::println);
	}
}
