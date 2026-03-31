
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicles implements GPS {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;
    private String location;

    Vehicles(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.location = "Unknown";
    }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Driver Name  : " + driverName);
        System.out.println("Rate per Km  : ₹" + ratePerKm);
        System.out.println("Location     : " + location);
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
class Cars extends Vehicles {

    public Cars(String vehicleId, String driverName) {
        super(vehicleId, driverName, 15.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 50;
    }
}
class Bikes extends Vehicles {

    public Bikes(String vehicleId, String driverName) {
        super(vehicleId, driverName, 8.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}
class Auto extends Vehicles {

    public Auto(String vehicleId, String driverName) {
        super(vehicleId, driverName, 10.0);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 20; 
    }
}
class RideService {

    public static void printFare(Vehicles vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Distance     : " + distance + " km");
        System.out.println("Total Fare   : ₹" + vehicle.calculateFare(distance));
        System.out.println("----------------------------------");
    }
}
public class RideHailing {

    public static void main(String[] args) {

        Vehicles car = new Cars("CAR101", "Rohit");
        Vehicles bike = new Bikes("BIKE202", "Amit");
        Vehicles auto = new Auto("AUTO303", "Suresh");

        car.updateLocation("Bhopal");
        bike.updateLocation("Indore");
        auto.updateLocation("Delhi");

        RideService.printFare(car, 10);
        RideService.printFare(bike, 10);
        RideService.printFare(auto, 10);
    }
}
