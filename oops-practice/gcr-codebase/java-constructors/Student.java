
public class Student {

    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {

    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    
    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);   // public
        System.out.println("Name: " + name);                // protected
        System.out.println("CGPA: " + getCGPA());            // private via method
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Rishabh", 8.5);
        pg.displayDetails();
    }
}

