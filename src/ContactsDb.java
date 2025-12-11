/*
 * Name: Horace Vial
 * Date: 12/10/2025
 * This class handles all database operations for contacts.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactsDb {

    // creates the table
    public static void createTable(Connection conn) {

        String sql = "CREATE TABLE IF NOT EXISTS Contacts (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FirstName VARCHAR(50) NOT NULL, " +
                "LastName VARCHAR(50) NOT NULL, " +
                "PhoneNumber VARCHAR(50) NOT NULL, " +
                "EmailAddress VARCHAR(100) NOT NULL, " +
                "Category VARCHAR(20) NOT NULL, " +
                "CompanyName VARCHAR(100), " +
                "JobTitle VARCHAR(100), " +
                "Relation VARCHAR(50)" +
                ");";

        try (Statement stmt = conn.createStatement()) {
            // run the CREATE TABLE statement
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // adds a contact
    public static void addContact(Connection conn, Contacts c) {

        String sql = "INSERT INTO Contacts " +
                "(FirstName, LastName, PhoneNumber, EmailAddress, Category, CompanyName, JobTitle, Relation) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // fill in the ? values for the SQL statement
            
            pstmt.setString(1, c.getFirstName());      
            pstmt.setString(2, c.getLastName());       
            pstmt.setString(3, c.getPhoneNumber());    
            pstmt.setString(4, c.getEmailAddress());   
            pstmt.setString(5, c.getContactType());    
            pstmt.setString(6, c.getCompanyName());    
            pstmt.setString(7, c.getJobTitle());       
            pstmt.setString(8, c.getRelation());       

            // inserts row
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // builds a contact from a row
    private static Contacts buildContact(ResultSet rs) throws SQLException {

        // read common fields
        String type = rs.getString("Category");
        String first = rs.getString("FirstName");
        String last = rs.getString("LastName");
        String phone = rs.getString("PhoneNumber");
        String email = rs.getString("EmailAddress");

        Contacts c;

        // create the correct contact type based on Category
        if (type.equals("family")) {
            c = new FamilyContact(first, last, phone, email,
                    rs.getString("Relation"));
        }
        else if (type.equals("business")) {
            c = new BusinessContact(first, last, phone, email,
                    rs.getString("CompanyName"),
                    rs.getString("JobTitle"));
        }
        else {
            c = new FriendContact(first, last, phone, email);
        }

        // set the ID so it matches the row in the database
        c.setId(rs.getInt("ID"));
        return c;
    }

    // returns all contacts
    public static ArrayList<Contacts> getAllContacts(Connection conn) {

        ArrayList<Contacts> list = new ArrayList<>();
        String sql = "SELECT * FROM Contacts";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through all rows and build contact objects
            while (rs.next()) {
                list.add(buildContact(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // returns contacts by category
    public static ArrayList<Contacts> getContactsByCategory(Connection conn, String category) {

        ArrayList<Contacts> list = new ArrayList<>();
        String sql = "SELECT * FROM Contacts WHERE Category = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // match the Category column
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(buildContact(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // returns contacts that match last name letter
    public static ArrayList<Contacts> getContactsByLastNameLetter(Connection conn, char letter) {

        ArrayList<Contacts> list = new ArrayList<>();
        String sql = "SELECT * FROM Contacts WHERE LastName LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setString(1, letter + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(buildContact(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // updates a contact
    public static void updateContact(Connection conn, int id, Contacts updated) {

        String sql = "UPDATE Contacts SET FirstName=?, LastName=?, PhoneNumber=?, EmailAddress=?, " +
                "Category=?, CompanyName=?, JobTitle=?, Relation=? WHERE ID=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set new values for the contact
            pstmt.setString(1, updated.getFirstName());
            pstmt.setString(2, updated.getLastName());
            pstmt.setString(3, updated.getPhoneNumber());
            pstmt.setString(4, updated.getEmailAddress());
            pstmt.setString(5, updated.getContactType());
            pstmt.setString(6, updated.getCompanyName());
            pstmt.setString(7, updated.getJobTitle());
            pstmt.setString(8, updated.getRelation());
            pstmt.setInt(9, id);  // ID of the row to change

            // run the UPDATE statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // deletes a contact
    public static void deleteContact(Connection conn, int id) {

        String sql = "DELETE FROM Contacts WHERE ID=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // choose which row to delete
            pstmt.setInt(1, id);

            // run the DELETE statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
