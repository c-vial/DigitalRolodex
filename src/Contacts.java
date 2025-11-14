/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 13, 2025
 * 
 *Base class that stores general contact info such as name, phone, and email.
 ********/

public class Contacts {

    // Base contact information
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

    // Format contact information
    public String getContactInformation() {
        return String.format("%s%s%n%s%s%n%s%s",
            "Name: ", Name,
            "Phone: ", PhoneNumber,
            "Email: ", EmailAddress);
    }
//override toString
    @Override
    public String toString() {
        return getContactInformation();
    }
}
