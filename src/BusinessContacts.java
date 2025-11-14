/*****************************************************************************************
 * Name: Horace Vial
 * Date: November 13, 2025
 *
 *Child class that extends Contacts. Adds company name and job title.
 *This shows inheritance.
 *****************************************************************************************/

public class BusinessContacts extends Contacts {

    // Additional business information
    private String CompanyName;
    private String JobTitle;

    // Constructor calls the base class constructor
    public BusinessContacts(String name, String phone, String email,
                            String company, String title) {
        super(name, phone, email);   // inheritance: call parent constructor
        CompanyName = company;
        JobTitle = title;
    }

    // Getters and setters
    public String getCompanyName() { return CompanyName; }
    public void setCompanyName(String company) { CompanyName = company; }

    public String getJobTitle() { return JobTitle; }
    public void setJobTitle(String title) { JobTitle = title; }

    // Return formatted business contact info
    public String getBusinessContactInformation() {
        return String.format("%s%n%s%s%n%s%s",
            super.getContactInformation(),
            "Company: ", CompanyName,
            "Job Title: ", JobTitle);
    }

    @Override
    public String toString() {
        return getBusinessContactInformation();
    }
}
