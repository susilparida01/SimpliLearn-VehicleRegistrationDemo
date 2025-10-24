import java.util.*;

// Main class for the vehicle registration portal
public class VehicleregistrationPortal {
	
	//Using TreeSet to maintain ascending order automatically
	private static TreeSet<String> vehicleSet = new TreeSet<>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		System.out.println("==============================================================");
		System.out.println("WELCOME TO VEHICLE REGISTRATION PORTAL");
		System.out.println("==============================================================");
		
		while (running) {
			System.out.println("\n ------MAIN MENU-----------");
			System.out.println("1. Add Vehicle Number");
			System.out.println("2. Delete Vehicle Number");
			System.out.println("3. Search Vehicle Number");
			System.out.println("4. Display all Vehicles (Ascending Order)");
			System.out.println("5. Return to Main Menu");
			System.out.println("6. Exit Application");
			System.out.println("Please Enter your choice: ");
			
			try {
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1:
					addVehicle(sc);
					break;
					
				case 2:
					deleteVehicle(sc);
					break;
					
				case 3:
					searchVehicle(sc);
					break;
					
				case 4: 
					displayVehicles();
					break;
					
				case 5:
					System.out.println("Returning to main Menu .....");
					break;
					
				case 6:
					System.out.println("Thank you for using the vehicle Registration Portal!");
					running = false;
					break;
					
				default:
					System.out.println("Invalid choice! Please select a valid option");
					
				}
			}catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter anumeric value.");
			}			
		}
		
		sc.close();		

	}
	
	// 1. Add Vehicles
	private static void addVehicle(Scanner sc) {
		System.out.println("Enter vehicle number (Uppercase letters and numbers only): ");
		String vehicleNo = sc.nextLine().trim().toUpperCase();
		
		//Validate input: only uppercase, digits, and limited length
		if (!vehicleNo.matches("[A-Z0-9]+")) {
			System.out.println("Invalid vehicle number! Only uppercase letters and digits are allowed");
			return;
		}
		
		if (vehicleSet.add(vehicleNo)) {
			System.out.println(" Vehicle " + vehicleNo + " added successfully");
		} else {
			System.out.println("Vehicle " + vehicleNo + " already exists!");
		}
	}
		
	
	// 2. Delete vehicles
	private static void deleteVehicle(Scanner sc) {
		System.out.println("Enter vehicle number to delete: ");
		String vehicleNo = sc.nextLine().trim().toUpperCase();
		
		if (vehicleSet.remove(vehicleNo)) {
			System.out.println(" Vehicle " + vehicleNo + " deleted successfully!");
		}else {
			System.out.println(" Vehicle " + vehicleNo + " not found!");
		}
	}
	
	// 3. Search vehicles
	private static void searchVehicle(Scanner sc) {
		System.out.println("Enter vehicle number to search: ");
		String vehicleNo = sc.nextLine().trim().toUpperCase();
		
		if (vehicleSet.contains(vehicleNo)) {
			System.out.println(" Vehicle " + vehicleNo + " is registered!");
		}else {
			System.out.println(" Vehicle " + vehicleNo + " is not registered!");
		}		
		
	}
	
	
	// 4. Display vehicles
	private static void displayVehicles() {
		if (vehicleSet.isEmpty()) {
			System.out.println(" No vehicle is registered yet!");
		}else {
			System.out.println("\n Registered vehicles (Ascending Order): ");
			for (String v : vehicleSet) {
				System.out.println(" - " + v);
			}
		}
	}
}
