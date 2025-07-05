
import java.util.ArrayList;
import java.util.List;
public class Company {
    private String name;
    private List<Vehicle> availableVehicles;
    private int lostFares;
    private int nextPassengerId;
    public Company(String name) {
        this.name = name;
        this.availableVehicles = new ArrayList<>();
        this.lostFares = 0;
        this.nextPassengerId = 1;
    }
    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }
    public boolean scheduleVehicle(Passenger passenger) {
        // Find an available vehicle with enough seats
        for (Vehicle vehicle : availableVehicles) {
            if (vehicle.isAvailable() && vehicle.getCapacity() >= passenger.getRequiredSeats()) {
                // Schedule the vehicle for this passenger
                vehicle.assignPassenger(passenger);
                return true;
            }
        }
        
        // No available vehicle found - lost fare
        lostFares++;
        return false;
    }
    public int getLostFares() {
        return lostFares;
    }

    public int getAvailableVehicleCount() {
        int count = 0;
        for (Vehicle vehicle : availableVehicles) {
            if (vehicle.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    public int getNextPassengerId() {
        return nextPassengerId++;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Company[name=" + name + ", availableVehicles=" + getAvailableVehicleCount() + 
               ", lostFares=" + lostFares + "]";
    }
}
    
