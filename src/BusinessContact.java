/*
 * Name: Horace Vial
 * Date: 12/10/2025
 * This class stores information for business contacts.
 */

public class BusinessContact extends Contacts {

    // properties
    private String CompanyName;
    private String JobTitle;

    // constructor
    public BusinessContact(String first, String last, String phone, String email,
                           String company, String job) {
        super(first, last, phone, email);
        CompanyName = company;
        JobTitle = job;
    }

    // getter methods
    @Override
    public String getCompanyName() {
        return CompanyName;
    }

    @Override
    public String getJobTitle() {
        return JobTitle;
    }

    @Override
    public String getContactType() {
        return "business";
    }

    @Override
    public String printContact() {
        return String.format("%s%nCompany: %s%nJob Title: %s",
                getContactInformation(),
                CompanyName,
                JobTitle);
    }
}
