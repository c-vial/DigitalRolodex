/********************************************************************
 * Name: Horace Vial
 * Date: 12/01/2025
 *
 * Child class for business contacts.
 * Inherits from the abstract Contacts class.
 ********************************************************************/

public class BusinessContacts extends Contacts {

    // properties - Business only
    private String CompanyName;
    private String JobTitle;

    // constructor
    public BusinessContacts(String name, String phone, String email,
                            String company, String title) {
        super(name, phone, email);
        CompanyName = company;
        JobTitle = title;
    }

    // constructor - Overloaded
    public BusinessContacts(String name, String phone, String email) {
        this(name, phone, email, "Unknown Company", "Unknown Title");
    }

    // getters/setters
    public String getCompanyName() { return CompanyName; }
    public void setCompanyName(String company) { CompanyName = company; }

    public String getJobTitle() { return JobTitle; }
    public void setJobTitle(String title) { JobTitle = title; }

    // contact type
    @Override
    public String getContactType() {
        return "Business Contact";
    }

    // format full business contact
    public String getBusinessContactInformation() {
        return String.format("%s%n%s%s%n%s%s",
                getContactInformation(),
                "Company: ", CompanyName,
                "Job Title: ", JobTitle);
    }

    // print full business info
    @Override
    public String printContact() {
        return getBusinessContactInformation();
    }

    @Override
    public String toString() {
        return getBusinessContactInformation();
    }
}
