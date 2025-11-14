import java.util.Scanner;

/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 13, 2025
 *
 *Main application. Displays project information, accepts simple
 *user input through a number list menu, and prints stored contacts.
 ***/

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("----- Horace Vial's Project Week 1 - Rolodex Application -----");
        System.out.println();
        System.out.println("Welcome to the Contacts Application!");

        // Create example contact objects
        Contacts a = new Contacts("Jane Doe", "555-1234", "jane.doe@example.com");
        BusinessContacts b = new BusinessContacts("Mark Smith", "555-9876",
                "mark.smith@techcorp.com", "TechCorp", "Project Manager");

        Rolodex c = new Rolodex();
        c.addContact(a);
        c.addContact(b);

        int choice = -1;   

    
        // Menu loop - continues until the user types 0 to exit

        while (choice != 0) {

            // Display menu
            System.out.println("Please choose an option below:");
            System.out.println("1. View basic contact");
            System.out.println("2. View business contact");
            System.out.println("3. View all contacts in Rolodex");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            // Read user input
            choice = input.nextInt();
            System.out.println(); // Line space

            // Handle menu choices
            if (choice == 1) {
                System.out.println("--- Basic Contact ---");
                System.out.println(a.toString());
                System.out.println();

            } else if (choice == 2) {
                System.out.println("--- Business Contact(Inheritance) ---");
                System.out.println(b.toString());
                System.out.println();

            } else if (choice == 3) {
                c.displayAllContacts();
                System.out.println();

            } else if (choice == 0) {
                System.out.println("Exiting application. Goodbye!\n");

            } else {
                System.out.println("Invalid choice. Please try again.\n");
            }
        }

        input.close();
    }
}
