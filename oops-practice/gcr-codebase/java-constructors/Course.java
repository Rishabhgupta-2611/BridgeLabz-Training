public class Course {

	private String courseName;
	private int duration;
	private double fee;

	static String instituteName = "BridgeLabz";

	Course(String courseName, int duration, double fee) {
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}

	void displayCourseDetails() {
		System.out.println("Institute Name: " + instituteName);
		System.out.println("Course Name: " + courseName);
		System.out.println("Duration: " + duration + " months");
		System.out.println("Fee: " + fee);
		System.out.println("----------------------------");
	}

	static void updateInstituteName(String name) {
		instituteName = name;
	}

	public static void main(String[] args) {
		Course c1 = new Course("Java", 3, 15000);
		Course c2 = new Course("Python", 2, 12000);
		c1.displayCourseDetails();
		c2.displayCourseDetails();

		Course.updateInstituteName("BridgeLabz Training Center");

		c1.displayCourseDetails();
	}
}
