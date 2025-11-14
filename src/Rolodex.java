/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 13, 2025
 *
 *Rolodex class that stores a list of Contacts objects.
 *This shows composition because this class has-a list of Contacts.
 */

import java.util.ArrayList;

public class Rolodex {

    // Composition: this class contains (has-a) list of Contacts
    private ArrayList<Contacts> ContactsList;

    // Constructor
    public Rolodex() {
        ContactsList = new ArrayList<>();
    }

    // Add a contact to the Rolodex
    public void addContact(Contacts c) {
        ContactsList.add(c);
    }

    // Display all stored contacts
    public void displayAllContacts() {
        System.out.println("----- Rolodex Contacts (Composition)-----");
        for (Contacts c : ContactsList) {
            System.out.println(c.toString());
            System.out.println("----------------------------");
        }
    }
}
