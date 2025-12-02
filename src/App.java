/********************************************************************
 * Name: Horace Vial
 * Date: 12/01/2025
 *
 * Main application for Week 3.
 ********************************************************************/

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println(" Horace Vial - Week 3 Rolodex Application");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("Welcome to my Rolodex Application");
        System.out.println("Please choose an option below.");
        System.out.println();

        // sample contacts - Polymorphism/Abstraction
        Contacts basic = new BasicContact("Jane Doe", "555-1234", "jane.doe@gmail.com");

        BusinessContacts business = new BusinessContacts(
                "Mark Smith",
                "555-9876",
                "mark.smith@techcorp.com",
                "TechCorp",
                "Project Manager"
        );

        // rolodex object - Composition
        Rolodex r = new Rolodex();
        r.addContact(basic);
        r.addContact(business);

        int choice = -1;

        // menu loop
        while (choice != 0) {

            System.out.println("1. View basic contact");
            System.out.println("2. View business contact");
            System.out.println("3. View all contacts");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = input.nextInt();
            System.out.println();

            // show basic contact
            if (choice == 1) {
                System.out.println(basic.getContactType());
                System.out.println(basic.printContact());
                System.out.println();

            // show business contact
            } else if (choice == 2) {
                System.out.println(business.getContactType());
                System.out.println(business.printContact());
                System.out.println();

            // show all contacts - Polymorphism
            } else if (choice == 3) {
                r.displayAllContacts();
                System.out.println();

            } else if (choice == 0) {
                System.out.println("Exiting program...");
                System.out.println();

            } else {
                System.out.println("Invalid choice.");
                System.out.println();
            }
        }

        input.close();
    }
}
