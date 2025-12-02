/********************************************************************
 * Name: Horace Vial
 * Date: 12/01/2025
 *
 * Class that stores contacts using composition.
 ********************************************************************/

import java.util.ArrayList;

public class Rolodex {

    // list of contacts - Composition
    private ArrayList<Contacts> ContactsList;

    // constructor
    public Rolodex() {
        ContactsList = new ArrayList<>();
    }

    // add contact - Composition
    public void addContact(Contacts c) {
        ContactsList.add(c);
    }

    // display all contacts - Polymorphism / Abstraction
    public void displayAllContacts() {
        System.out.println("----- Rolodex Contacts -----");
        for (Contacts c : ContactsList) {
            System.out.println("Contact Type: " + c.getContactType());
            System.out.println(c.printContact());
            System.out.println("----------------------------");
        }
    }
}
