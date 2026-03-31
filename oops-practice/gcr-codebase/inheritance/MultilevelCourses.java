class Course {
	String courseName;
	int duration;

	Course(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}

	String getCourseInfo() {
		return courseName + " (" + duration + " weeks)";
	}
}

class OnlineCourse extends Course {
	String platform;
	boolean isRecorded;

	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}

	@Override
	String getCourseInfo() {
		return super.getCourseInfo() + " on " + platform + (isRecorded ? " [Recorded]" : " [Live]");
	}
}

class PaidOnlineCourse extends OnlineCourse {
	double fee;
	double discount;

	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee,
			double discount) {
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}

	double getPriceAfterDiscount() {
		return fee - (fee * discount / 100.0);
	}
}

public class MultilevelCourses {
	public static void main(String[] args) {
		Course c = new Course("Intro to Java", 8);
		OnlineCourse o = new OnlineCourse("Data Structures", 10, "Udemy", true);
		PaidOnlineCourse p = new PaidOnlineCourse("Algorithms", 12, "Coursera", false, 199.0, 15.0);

		System.out.println(c.getCourseInfo());
		System.out.println(o.getCourseInfo());
		System.out.println(p.getCourseInfo());
		System.out.println("Price after discount: " + p.getPriceAfterDiscount());
	}
}