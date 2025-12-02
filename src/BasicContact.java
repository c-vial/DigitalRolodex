/********************************************************************
 * Name: Horace Vial
 * Date: 12/01/2025
 *
 * Child class that extends the abstract Contacts class.
 ********************************************************************/

public class BasicContact extends Contacts {

    // constructor
    public BasicContact(String name, String phone, String email) {
        super(name, phone, email);
    }

    // contact type
    @Override
    public String getContactType() {
        return "Basic Contact";
    }
}
