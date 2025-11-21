/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 20, 2025
 *
 * Rolodex class that stores contacts (composition).
 *****************************************************************************************/

import java.util.ArrayList;

public class Rolodex {

    // Rolodex has-a list of contacts (composition)
    private ArrayList<Contacts> ContactsList;

    // Constructor
    public Rolodex() {
        ContactsList = new ArrayList<>();
    }

    // Add a contact
    public void addContact(Contacts c) {
        ContactsList.add(c);
    }

    // Display all contacts (polymorphism)
    public void displayAllContacts() {
        System.out.println("----- Rolodex Contacts -----");
        for (Contacts c : ContactsList) {
            System.out.println(c.printContact());
            System.out.println("----------------------------");
        }
    }
}
