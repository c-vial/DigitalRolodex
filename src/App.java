/*
 * Name: Horace Vial
 * Date: 12/10/2025
 * Main program that handles user menu choice and displays contacts.
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        final String dbName = "database.db";

        // welcome messages
        System.out.println("\nWelcome to Horace Vial's Rolodex program!\n");
        System.out.println("Use the menu numbers to add, view, update, or delete contacts.\n");

        // open connection and create table if needed     //
        Connection conn = SQLiteDatabase.connect(dbName);
        ContactsDb.createTable(conn);

        Scanner input = new Scanner(System.in);
        int choice = 0;

        // main menu loop
        while (choice != 7) {

            System.out.println("1. Add contact");
            System.out.println("2. View all contacts");
            System.out.println("3. View by category");
            System.out.println("4. View by first letter of last name");
            System.out.println("5. Update contact");
            System.out.println("6. Delete contact");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            // read menu choice
            choice = Integer.parseInt(input.nextLine());
            System.out.println();

            if (choice == 1) {
                addContact(conn, input);
            }
            else if (choice == 2) {
                viewAllContacts(conn);
            }
            else if (choice == 3) {
                viewByCategory(conn, input);
            }
            else if (choice == 4) {
                viewByLetter(conn, input);
            }
            else if (choice == 5) {
                updateContact(conn, input);
            }
            else if (choice == 6) {
                deleteContact(conn, input);
            }
            else if (choice == 7) {
                System.out.println("Exiting program.");
            }
            else {
                System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        input.close();
    }

    // adds a contact
    private static void addContact(Connection conn, Scanner input) {

        // ask what type of contact to create
        System.out.print("Enter contact type (family, business, friend): ");
        String type = input.nextLine().toLowerCase();

        // common fields
        System.out.print("First name: ");
        String first = input.nextLine();

        System.out.print("Last name: ");
        String last = input.nextLine();

        System.out.print("Phone: ");
        String phone = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        Contacts c;

        // create the correct type
        if (type.equals("family")) {
            System.out.print("Relation: ");
            String relation = input.nextLine();
            c = new FamilyContact(first, last, phone, email, relation);
        }
        else if (type.equals("business")) {
            System.out.print("Company: ");
            String company = input.nextLine();
            System.out.print("Job title: ");
            String job = input.nextLine();
            c = new BusinessContact(first, last, phone, email, company, job);
        }
        else if (type.equals("friend")) {
            c = new FriendContact(first, last, phone, email);
        }
        else {
            System.out.println("Invalid type.");
            return;
        }

        // send the new contact to the database
        ContactsDb.addContact(conn, c);
        System.out.println("Contact added.");
    }

    // shows all contacts
    private static void viewAllContacts(Connection conn) {

        // get every contact
        ArrayList<Contacts> list = ContactsDb.getAllContacts(conn);

        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        // print each contact
        for (Contacts c : list) {
            System.out.println("--------------------");
            System.out.println("ID: " + c.getId());
            System.out.println("Type: " + c.getContactType());
            System.out.println(c.printContact());
        }
    }

    // shows contacts by category
    private static void viewByCategory(Connection conn, Scanner input) {

        // choose the type to show
        System.out.print("Enter category (family, business, friend): ");
        String type = input.nextLine().toLowerCase();

        ArrayList<Contacts> list = ContactsDb.getContactsByCategory(conn, type);

        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        // print results
        for (Contacts c : list) {
            System.out.println("--------------------");
            System.out.println("ID: " + c.getId());
            System.out.println(c.printContact());
        }
    }

    // shows contacts by first letter of last name
    private static void viewByLetter(Connection conn, Scanner input) {

        // get the search letter
        System.out.print("Enter first letter of last name: ");
        String line = input.nextLine();

        if (line.length() == 0) {
            System.out.println("No letter entered.");
            return;
        }

        char letter = Character.toUpperCase(line.charAt(0));

        ArrayList<Contacts> list = ContactsDb.getContactsByLastNameLetter(conn, letter);

        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        // print results
        for (Contacts c : list) {
            System.out.println("--------------------");
            System.out.println("ID: " + c.getId());
            System.out.println(c.printContact());
        }
    }

    // updates a contact
    private static void updateContact(Connection conn, Scanner input) {

        // find which contact to update
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(input.nextLine());

        // ask for new values
        System.out.print("Enter new type (family, business, friend): ");
        String type = input.nextLine().toLowerCase();

        System.out.print("First name: ");
        String first = input.nextLine();

        System.out.print("Last name: ");
        String last = input.nextLine();

        System.out.print("Phone: ");
        String phone = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        Contacts updated;

        // create updated version of the contact
        if (type.equals("family")) {
            System.out.print("Relation: ");
            String relation = input.nextLine();
            updated = new FamilyContact(first, last, phone, email, relation);
        }
        else if (type.equals("business")) {
            System.out.print("Company: ");
            String company = input.nextLine();
            System.out.print("Job title: ");
            String job = input.nextLine();
            updated = new BusinessContact(first, last, phone, email, company, job);
        }
        else {
            updated = new FriendContact(first, last, phone, email);
        }

        // update the database row
        ContactsDb.updateContact(conn, id, updated);
        System.out.println("Contact updated.");
    }

    // deletes a contact
    private static void deleteContact(Connection conn, Scanner input) {

        // choose ID to delete
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(input.nextLine());

        // remove the row
        ContactsDb.deleteContact(conn, id);
        System.out.println("Contact deleted.");
    }
}
