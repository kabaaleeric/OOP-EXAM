//class to demontrate how the BALEXTRANIT transportation system works

public class BALEXTRANITDemo {
    
    public static void main(String[] args) {
        
        System.out.println("BALEXTRANIT (U) LTD Transportation System Demo\n");
        
        // Create the company
        Company company = new Company("BALEXTRANIT (U) LTD");
        System.out.println("Created: " + company.getName());
        
        // Add some vehicles to the fleet
        Vehicle taxi1 = new Vehicle();
        Vehicle taxi2 = new Vehicle();
        Vehicle shuttle1 = new Vehicle();
        
        company.addVehicle(taxi1);
        company.addVehicle(taxi2);
        company.addVehicle(shuttle1);
        
        System.out.println("Added vehicles to fleet:");
        System.out.println("- " + taxi1);
        System.out.println("- " + taxi2);
        System.out.println("- " + shuttle1);
        System.out.println();
        
        // Create a passenger source (could be a hotel, corporate company, etc.)
        PassengerSource hotelSource = new PassengerSource(company);
        System.out.println("Created passenger source (Hotel)");
        
        // Simulate some pickup requests
        System.out.println("\n Simulating Pickup Requests");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nRequest #" + i + ":");
            boolean scheduled = hotelSource.requestPickup();
            
            if (scheduled) {
                System.out.println(" Pickup scheduled successfully!");
            } else {
                System.out.println(" No available vehicle - request lost!");
            }
            
            System.out.println("Available vehicles: " + company.getAvailableVehicleCount());
            System.out.println("Lost fares: " + company.getLostFares());
        }
        
        System.out.println("\nFinal Statistics");
        System.out.println("Total lost fares: " + company.getLostFares());
        System.out.println("Available vehicles: " + company.getAvailableVehicleCount());
        
        System.out.println("\nDemo Complete");
    }
}
    

