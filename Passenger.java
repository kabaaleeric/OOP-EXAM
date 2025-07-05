
public class Passenger {
    private int id;
    private Location pickupLocation;
    private Location destinationLocation;
    private int requiredSeats;
 
    public Passenger(int id, Location pickupLocation, Location destinationLocation, int requiredSeats) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
        this.requiredSeats = requiredSeats;
    }
    
    public int getId() {
        return id;
    }
  
    public Location getPickupLocation() {
        return pickupLocation;
    }
    
   
    public Location getDestinationLocation() {
        return destinationLocation;
    }
   
    public int getRequiredSeats() {
        return requiredSeats;
    }
    
    public String toString() {
        return "Passenger[id=" + id + ", pickup=" + pickupLocation + 
               ", destination=" + destinationLocation + ", seats=" + requiredSeats + "]";
    }
}
