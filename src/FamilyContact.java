/*
 * Name: Horace Vial
 * Date: 12/05/2025
 * This class stores information for family contacts. Child of Contacts.
 */

public class FamilyContact extends Contacts {

    // properties
    private String Relation;

    // constructor
    public FamilyContact(String first, String last, String phone, String email, String relation) {
        super(first, last, phone, email);
        Relation = relation;
    }

    // getter methods
    @Override
    public String getRelation() {
        return Relation;
    }

    @Override
    public String getContactType() {
        return "family";
    }

    @Override
    public String printContact() {
        return String.format("%s%nRelation: %s",
                getContactInformation(),
                Relation);
    }
}
