// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract class Vehicle
abstract class Vehicle {
    private int vehicleId;          // Encapsulation
    private String driverName;
    protected double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate Per Km: " + ratePerKm);
    }
}

// Car class
class Car extends Vehicle implements GPS {

    private String location = "Not Set";

    public Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    private String location = "Not Set";

    public Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return distance * ratePerKm * 0.9; // cheaper rate
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    private String location = "Not Set";

    public Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return distance * ratePerKm + 20; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

// Main class
public class RideHailingApplication {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car(1, "Driver1", 15),
                new Bike(2, "Driver2", 10),
                new Auto(3, "Driver3", 12)
        };

        double distance = 10; // 10 km ride

        for (Vehicle v : vehicles) {

            v.getVehicleDetails();
            double fare = v.calculateFare(distance);
            System.out.println("Fare: " + fare);

            GPS gps = (GPS) v;
            gps.updateLocation("City Center");
            System.out.println("Location: " + gps.getCurrentLocation());

            System.out.println("----------------------");
        }
    }
}
