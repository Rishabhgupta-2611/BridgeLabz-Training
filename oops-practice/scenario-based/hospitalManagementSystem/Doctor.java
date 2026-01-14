package hospitalManagementSystem;

class Doctor extends Person {

    private String specialization;
    private double consultationFee;

    public Doctor(String id, String name, String specialization, double consultationFee) {
        super(id, name);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public double calculateConsultationFee() {
        return consultationFee;
    }

    public String getName() {
        return name;
    }
}
