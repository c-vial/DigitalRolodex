/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 20, 2025
 *
 * Business contact class extends Contacts while implementing printContact() (inheritance and polymorphism).
 *****************************************************************************************/

public class BusinessContacts extends Contacts {

    // Properties
    private String CompanyName;
    private String JobTitle;

    // Constructor
    public BusinessContacts(String name, String phone, String email,
                            String company, String title) {
        super(name, phone, email);  // Call base Contacts constructor
        CompanyName = company;
        JobTitle = title;
    }

    // Getters and setters
    public String getCompanyName() { return CompanyName; }
    public void setCompanyName(String company) { CompanyName = company; }

    public String getJobTitle() { return JobTitle; }
    public void setJobTitle(String title) { JobTitle = title; }

    // Format business contact info
    public String getBusinessContactInformation() {
        return String.format("%s%n%s%s%n%s%s",
                super.getContactInformation(),
                "Company: ", CompanyName,
                "Job Title: ", JobTitle);
    }

    // Override printContact() method (polymorphism)
    @Override
    public String printContact() {
        return getBusinessContactInformation();
    }

    // toString override
    @Override
    public String toString() {
        return getBusinessContactInformation();
    }
}
