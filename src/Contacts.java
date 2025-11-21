/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 20, 2025
 * 
 * Base class for contact info while implementing printContact()
 *****************************************************************************************/

public class Contacts implements ContactMethods {

    // Properties
    private String Name;
    private String PhoneNumber;
    private String EmailAddress;

    // Constructor
    public Contacts(String name, String phone, String email) {
        Name = name;
        PhoneNumber = phone;
        EmailAddress = email;
    }

    // Getters and setters
    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phone) { PhoneNumber = phone; }

    public String getEmailAddress() { return EmailAddress; }
    public void setEmailAddress(String email) { EmailAddress = email; }

    // Format basic contact info
    public String getContactInformation() {
        return String.format("%s%s%n%s%s%n%s%s",
                "Name: ", Name,
                "Phone: ", PhoneNumber,
                "Email: ", EmailAddress);
    }

    // Base printContact() method (implements interface)
    @Override
    public String printContact() {
        return getContactInformation();
    }

    // toString override
    @Override
    public String toString() {
        return getContactInformation();
    }
}
