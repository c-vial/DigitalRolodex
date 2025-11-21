/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 20, 2025
 *
 * Main application with  menu.
 *****************************************************************************************/
import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("----- Horace Vial's Project Week 2 - Rolodex Application -----");
        System.out.println();
        System.out.println("Welcome to the Contacts Application!");

        // Example contacts
        Contacts a = new Contacts("Jane Doe", "555-1234", "jane.doe@example.com");
        BusinessContacts b = new BusinessContacts("Mark Smith", "555-9876",
                "mark.smith@techcorp.com", "TechCorp", "Project Manager");

        // Rolodex object
        Rolodex r = new Rolodex();
        r.addContact(a);
        r.addContact(b);

        int choice = -1;

        // Menu loop
        while (choice != 0) {

            // Menu options
            System.out.println("Please choose an option:");
            System.out.println("1. View basic contact");
            System.out.println("2. View business contact");
            System.out.println("3. View all contacts");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = input.nextInt();
            System.out.println();

            // Handle choices
            if (choice == 1) {
                System.out.println(a.printContact());
                System.out.println();

            } else if (choice == 2) {
                System.out.println(b.printContact());
                System.out.println();

            } else if (choice == 3) {
                r.displayAllContacts();
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
