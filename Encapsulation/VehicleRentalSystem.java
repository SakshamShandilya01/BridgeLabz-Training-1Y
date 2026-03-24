
// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate; // accessible in subclasses

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + type);
    }
}

// Car class
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; // fixed insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 500";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: 200";
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 1000";
    }
}

// Main class
public class VehicleRentalSystem {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("V101", 2000),
                new Bike("V102", 800),
                new Truck("V103", 5000)
        };

        int days = 3;

        for (Vehicle v : vehicles) {

            v.displayDetails();

            double rent = v.calculateRentalCost(days);
            double insurance = ((Insurable) v).calculateInsurance();

            System.out.println("Rental Cost: " + rent);
            System.out.println("Insurance: " + insurance);
            System.out.println("Total Cost: " + (rent + insurance));
            System.out.println("----------------------");
        }
    }
}
