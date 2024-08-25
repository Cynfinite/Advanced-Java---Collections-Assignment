import java.util.*;

// Define a class to represent an Address
class Address {
    private String firstName;
    private String lastName;
    private String streetAddress;

    // Constructor to initialize the Address object
    public Address(String firstName, String lastName, String streetAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
    }

    // Getter method for last name
    public String getLastName() {
        return lastName;
    }

    // Override toString to format the address as a string
    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + streetAddress;
    }
}

// Define a class to represent an AddressBook
class AddressBook {
    private List<Address> addresses = new ArrayList<>();

    // Method to add an address to the AddressBook
    public void addAddress(Address address) {
        addresses.add(address);
    }

    // Method to remove an address by last name
    public void removeAddress(String lastName) {
        addresses.removeIf(address -> address.getLastName().equals(lastName));
    }

    // Method to get the count of addresses in the AddressBook
    public int getAddressCount() {
        return addresses.size();
    }

    // Method to get a list of all addresses in the AddressBook
    public List<Address> getAllAddresses() {
        return addresses;
    }

    // Method to find an address by last name
    public Address findAddressByLastName(String lastName) {
        for (Address address : addresses) {
            if (address.getLastName().equals(lastName)) {
                return address;
            }
        }
        return null; // Return null if the address is not found
    }
}

// Define a class to handle console input and output
class ConsoleIO {
    private Scanner scanner = new Scanner(System.in);

    // Method to read a line of text from the console
    public String readLine() {
        return scanner.nextLine();
    }

    // Method to print a message to the console without a newline
    public void print(String message) {
        System.out.print(message);
    }

    // Method to print a message to the console with a newline
    public void println(String message) {
        System.out.println(message);
    }
}

// Main class to control the address book application
public class AddressBookController {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();
        AddressBook addressBook = new AddressBook();

        // Main program loop
        while (true) {
            console.println("Initial Menu:");
            console.println("Please select the operation you wish to perform:");
            console.println("1. Add Address");
            console.println("2. Delete Address");
            console.println("3. Find Address");
            console.println("4. List Address Count");
            console.println("5. List All Addresses");
            console.println("6. Exit");

            int choice = Integer.parseInt(console.readLine());

            switch (choice) {
                case 1:
                    console.println("Add Address Menu:");
                    console.print("Please enter first name: ");
                    String firstName = console.readLine();
                    console.print("Please enter last name: ");
                    String lastName = console.readLine();
                    console.print("Please enter street address: ");
                    String streetAddress = console.readLine();
                    Address newAddress = new Address(firstName, lastName, streetAddress);
                    addressBook.addAddress(newAddress);
                    console.println("Address Added. Press Enter to continue.");
                    console.readLine();
                    break;
                case 2:
                    console.print("Please enter last name to delete: ");
                    String lastNameToDelete = console.readLine();
                    addressBook.removeAddress(lastNameToDelete);
                    console.println("Address Deleted. Press Enter to continue.");
                    console.readLine();
                    break;
                case 3:
                    console.print("Please enter last name to find: ");
                    String lastNameToFind = console.readLine();
                    Address foundAddress = addressBook.findAddressByLastName(lastNameToFind);
                    if (foundAddress != null) {
                        console.println("Address found: " + foundAddress);
                    } else {
                        console.println("Address not found.");
                    }
                    console.println("Press Enter to continue.");
                    console.readLine();
                    break;
                case 4:
                    int addressCount = addressBook.getAddressCount();
                    console.println("Number of Addresses in the Address Book: " + addressCount);
                    console.println("Press Enter to continue.");
                    console.readLine();
                    break;
                case 5:
                    List<Address> allAddresses = addressBook.getAllAddresses();
                    console.println("List of Addresses:");
                    for (Address address : allAddresses) {
                        console.println(address.toString());
                    }
                    console.println("Press Enter to continue.");
                    console.readLine();
                    break;
                case 6:
                    console.println("Exiting the Address Book program.");
                    System.exit(0);
                default:
                    console.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
