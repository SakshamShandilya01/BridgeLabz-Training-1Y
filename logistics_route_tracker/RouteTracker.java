package com.logistics_route_tracker;
import java.util.*;

// Base interface
interface Checkpoint {
    String getCheckpointId();
    String getLocationName();
    double getDistanceFromLast(); // km
    double getExpectedDuration(); // minutes
    double getActualDuration();   // minutes

    boolean isCritical();
    String getType();

    boolean isDelayed();
    double calculatePenalty();
}

// Delivery checkpoint
class DeliveryCheckpoint implements Checkpoint {
    private final String checkpointId;
    private final String locationName;
    private final double distanceFromLast;
    private final double expectedDuration;
    private final double actualDuration;

    public DeliveryCheckpoint(String id, String name, double dist, double exp, double act) {
        checkpointId = id;
        locationName = name;
        distanceFromLast = dist;
        expectedDuration = exp;
        actualDuration = act;
    }

    public String getCheckpointId() { return checkpointId; }
    public String getLocationName() { return locationName; }
    public double getDistanceFromLast() { return distanceFromLast; }
    public double getExpectedDuration() { return expectedDuration; }
    public double getActualDuration() { return actualDuration; }

    public boolean isCritical() { return true; }
    public String getType() { return "Delivery"; }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public double calculatePenalty() {
        if (!isDelayed()) return 0.0;
        return (actualDuration - expectedDuration) * 2;
    }
}

// Fuel checkpoint
class FuelCheckpoint implements Checkpoint {
    private final String checkpointId;
    private final String locationName;
    private final double distanceFromLast;
    private final double expectedDuration;
    private final double actualDuration;

    public FuelCheckpoint(String id, String name, double dist, double exp, double act) {
        checkpointId = id;
        locationName = name;
        distanceFromLast = dist;
        expectedDuration = exp;
        actualDuration = act;
    }

    public String getCheckpointId() { return checkpointId; }
    public String getLocationName() { return locationName; }
    public double getDistanceFromLast() { return distanceFromLast; }
    public double getExpectedDuration() { return expectedDuration; }
    public double getActualDuration() { return actualDuration; }

    public boolean isCritical() { return true; }
    public String getType() { return "Fuel"; }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public double calculatePenalty() {
        return isDelayed() ? 10.0 : 0.0;
    }
}

// Rest checkpoint
class RestCheckpoint implements Checkpoint {
    private final String checkpointId;
    private final String locationName;
    private final double distanceFromLast;
    private final double expectedDuration;
    private final double actualDuration;

    public RestCheckpoint(String id, String name, double dist, double exp, double act) {
        checkpointId = id;
        locationName = name;
        distanceFromLast = dist;
        expectedDuration = exp;
        actualDuration = act;
    }

    public String getCheckpointId() { return checkpointId; }
    public String getLocationName() { return locationName; }
    public double getDistanceFromLast() { return distanceFromLast; }
    public double getExpectedDuration() { return expectedDuration; }
    public double getActualDuration() { return actualDuration; }

    public boolean isCritical() { return false; }
    public String getType() { return "Rest"; }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public double calculatePenalty() {
        if (!isDelayed() || actualDuration - expectedDuration <= 30) {
            return 0.0;
        }
        return (actualDuration - expectedDuration) * 0.5;
    }
}

// Route using Collections Framework (ArrayList)
class Route {
    private final List<Checkpoint> checkpoints;

    public Route() {
        this.checkpoints = new ArrayList<>();
    }

    public void addCheckpoint(Checkpoint checkpoint) {
        checkpoints.add(checkpoint);
    }

    public boolean removeCheckpoint(String checkpointId) {
        return checkpoints.removeIf(cp -> cp.getCheckpointId().equals(checkpointId));
    }

    public Checkpoint findCheckpoint(String checkpointId) {
        return checkpoints.stream()
                .filter(cp -> cp.getCheckpointId().equals(checkpointId))
                .findFirst()
                .orElse(null);
    }

    public double computeTotalDistance() {
        return checkpoints.stream()
                .mapToDouble(Checkpoint::getDistanceFromLast)
                .sum();
    }

    public double computeTotalPenalty() {
        return checkpoints.stream()
                .mapToDouble(Checkpoint::calculatePenalty)
                .sum();
    }

    public void printRoute() {
        int index = 1;
        for (Checkpoint cp : checkpoints) {
            String timeStatus = cp.isDelayed() ? "Delayed" : "On Time";
            System.out.printf(
                    "%d. %s – %s – %s – Penalty: %.1f%n",
                    index,
                    cp.getType() + "Checkpoint",
                    cp.getLocationName(),
                    timeStatus,
                    cp.calculatePenalty()
            );
            index++;
        }
    }

    public boolean isConsistent() {
        return checkpoints.stream()
                .noneMatch(cp -> cp.isCritical() && cp.isDelayed());
        // or define your own logic, e.g., all critical IDs must be present
    }
}

// Driver class (now using Route instead of RouteLinkedList)
class Driver {
    private final String driverId;
    private final String name;
    private final Route routeHistory;

    public Driver(String id, String name) {
        this.driverId = id;
        this.name = name;
        this.routeHistory = new Route();
    }

    public void addCheckpoint(Checkpoint cp) {
        routeHistory.addCheckpoint(cp);
    }

    public boolean removeCheckpoint(String id) {
        return routeHistory.removeCheckpoint(id);
    }

    public void printSummary() {
        System.out.printf("Driver: %s – %s%n", driverId, name);
        System.out.println("Route Summary:");

        routeHistory.printRoute();

        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty = routeHistory.computeTotalPenalty();
        double routeScore = totalDistance - totalPenalty;

        System.out.printf("Total Distance: %.1f km%n", totalDistance);
        System.out.printf("Total Penalty: %.1f%n", totalPenalty);
        System.out.printf("Route Score: %.1f%n", routeScore);

        if (routeHistory.isConsistent()) {
            System.out.println("Critical Route Check: All required checkpoints present");
        } else {
            System.out.println("Critical Route Check: Some required checkpoints missing or inconsistent");
        }
    }
}
public class RouteTracker {
    public static void main(String[] args) {
        Driver driver = new Driver("D1204", "Kavita Nair");

        driver.addCheckpoint(new DeliveryCheckpoint("D1", "Warehouse A", 40.0, 60, 70));
        driver.addCheckpoint(new FuelCheckpoint("F1", "Pump 12", 30.0, 15, 14));
        driver.addCheckpoint(new RestCheckpoint("R1", "Motel X", 20.0, 30, 65));
        driver.addCheckpoint(new DeliveryCheckpoint("D2", "Client Hub", 30.0, 45, 60));

        driver.printSummary();
    }
}
