/*
 * Name: Horace Vial
 * Date: 12/10/2025
 * This class is the base class for all contact types.
 */

public abstract class Contacts implements ContactMethods {

    // properties
    private int Id;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String EmailAddress;

    // constructor
    public Contacts(String firstName, String lastName, String phone, String email) {
        Id = 0;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phone;
        EmailAddress = email;
    }

    // getter and setter methods
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    // optional fields used only by some contact types
    public String getCompanyName() {
        return "";
    }

    public String getJobTitle() {
        return "";
    }

    public String getRelation() {
        return "";
    }

    public String getContactType() {
        return "";
    }

    // formats contact information
    public String getContactInformation() {
        return String.format("%s%s %s%n%s%s%n%s%s",
                "Name: ", FirstName, LastName,
                "Phone: ", PhoneNumber,
                "Email: ", EmailAddress);
    }

    @Override
    public String printContact() {
        return getContactInformation();
    }
}
