
    
    import java.util.Random;

public class PassengerSource {
    private Company company;
    private Random random;
   
    public PassengerSource(Company company) {
        this.company = company;
        this.random = new Random();
    }

    public boolean requestPickup() {
        // Generate random pickup location (x, y coordinates from 0 to 100)
        Location pickupLocation = generateRandomLocation();
        
        // Generate random destination location (x, y coordinates from 0 to 100)
        Location destinationLocation = generateRandomLocation();
        
        // Create a new Passenger with random number of seats (1-4)
        int requiredSeats = random.nextInt(4) + 1; // 1 to 4 seats
        Passenger passenger = new Passenger(
            company.getNextPassengerId(),
            pickupLocation,
            destinationLocation,
            requiredSeats
        );
        
        // Use the company to schedule a vehicle
        boolean scheduled = company.scheduleVehicle(passenger);
        
        // Return true if successfully scheduled, false otherwise
        return scheduled;
    }
   
    private Location generateRandomLocation() {
        int x = random.nextInt(101); // 0 to 100 inclusive
        int y = random.nextInt(101); // 0 to 100 inclusive
        return new Location(x, y);
    }
   
    public Company getCompany() {
        return company;
    }
}

