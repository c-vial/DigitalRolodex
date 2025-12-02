/********************************************************************
 * Name: Horace Vial
 * Date: 12/01/2025
 *
 * Abstract class used as the base for all contact types.
 * Holds shared properties and constructors.
 ********************************************************************/

public abstract class Contacts implements ContactMethods {

    // properties
    private String Name;
    private String PhoneNumber;
    private String EmailAddress;

    // constructor
    public Contacts(String name, String phone, String email) {
        Name = name;
        PhoneNumber = phone;
        EmailAddress = email;
    }

    // constructor - Overloaded
    public Contacts(String name, String phone) {
        this(name, phone, "not@provided.com");
    }

    // getters/setters
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phone) { PhoneNumber = phone; }

    public String getEmailAddress() { return EmailAddress; }
    public void setEmailAddress(String email) { EmailAddress = email; }

    // abstract method
    public abstract String getContactType();

    // shared formatting method
    public String getContactInformation() {
        return String.format("%s%s%n%s%s%n%s%s",
                "Name: ", Name,
                "Phone: ", PhoneNumber,
                "Email: ", EmailAddress);
    }

    @Override
    public String printContact() {
        return getContactInformation();
    }

    @Override
    public String toString() {
        return getContactInformation();
    }
}
