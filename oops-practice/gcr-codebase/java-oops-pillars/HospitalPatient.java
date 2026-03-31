import java.util.*;

interface MedicalRecord {
	void addRecord(String record);

	void viewRecord();
}

abstract class Patient {
	private String patientId;
	private String name;
	private int age;

	private List<Patient> medicalRecords = new ArrayList<>();

	public Patient(String patientId, String name, int age) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void addRecord(Patient record) {
		medicalRecords.add(record);
	}

	public void viewRecord(List<Patient> medicalRecords) {
		for (Patient record : medicalRecords) {
			System.out.println(
					"Record: " + record.getPatientId() + ", Name: " + record.getName() + ", Age: " + record.getAge());
		}
	}

	public abstract void calculateBill();

	public abstract void displayPatientInfo();
}

class InPatient extends Patient {
	private int numberOfDays;
	private double dailyRate;

	public InPatient(String patientId, String name, int age, int numberOfDays, double dailyRate) {
		super(patientId, name, age);
		this.numberOfDays = numberOfDays;
		this.dailyRate = dailyRate;
	}

	@Override
	public void calculateBill() {
		System.out.print("Calculating bill for In-Patient : ");
		System.out.println(numberOfDays * dailyRate);
	}

	@Override
	public void displayPatientInfo() {
		System.out.println("In-Patient Details:");
		System.out.println("Patient ID: " + getPatientId());
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Number of Days: " + numberOfDays);
		System.out.println("Daily Rate: " + dailyRate);
		System.out.println("----------------------------");
	}
}

class OutPatient extends Patient {
	private int numberOfVisits;
	private double visitFee;

	public OutPatient(String patientId, String name, int age, int numberOfVisits, double visitFee) {
		super(patientId, name, age);
		this.numberOfVisits = numberOfVisits;
		this.visitFee = visitFee;
	}

	@Override
	public void calculateBill() {
		System.out.print("Calculating bill for Out-Patient : ");
		System.out.println(numberOfVisits * visitFee);
	}

	@Override
	public void displayPatientInfo() {
		System.out.println("Out-Patient Details:");
		System.out.println("Patient ID: " + getPatientId());
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Number of Visits: " + numberOfVisits);
		System.out.println("Visit Fee: " + visitFee);
		System.out.println("----------------------------");
	}
}

public class HospitalPatient {
	static List<Patient> patients = new ArrayList<>();

	public static void main(String[] args) {
		Patient inPatient = new InPatient("IP001", "John Doe", 45, 5, 2000.0);
		Patient outPatient = new OutPatient("OP001", "Jane Smith", 30, 3, 500.0);
		inPatient.displayPatientInfo();
		inPatient.calculateBill();
		outPatient.displayPatientInfo();
		outPatient.calculateBill();
		patients.add(inPatient);
		patients.add(outPatient);
		inPatient.viewRecord(patients);
	}
}
