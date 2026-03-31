public class Patient {

	private static String hospitalName = "City Hospital";
	private static int totalPatients = 0;

	private final String patientID;
	private String name;
	private int age;
	private String ailment;

	Patient(String patientID, String name, int age, String ailment) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}

	public static int getTotalPatients() {
		return totalPatients;
	}

	public void displayDetails() {
		if (this instanceof Patient) {
			System.out.println("Hospital Name: " + hospitalName);
			System.out.println("Patient ID: " + patientID);
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Ailment: " + ailment);
		} else {
			System.out.println("Invalid instance");
		}
	}

	public static void main(String[] args) {

		Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
		Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");
		System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
		p1.displayDetails();
		p2.displayDetails();
	}
}