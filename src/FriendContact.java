/*
 * Name: Horace Vial
 * Date: 12/05/2025
 * This class stores information for friend contacts. Child of Contacts.
 */

public class FriendContact extends Contacts {

    // constructor
    public FriendContact(String first, String last, String phone, String email) {
        super(first, last, phone, email);
    }

    @Override
    public String getContactType() {
        return "friend";
    }
}
