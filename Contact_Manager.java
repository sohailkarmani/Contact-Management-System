
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Contact_Manager {
    Scanner scanner = new Scanner(System.in);

    private Connection connection = null;
    PreparedStatement preparedStatement = null;

    public Contact_Manager() {

        this.connection = DatabaseConnection.getConnection();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while ((!exit)) {
            System.out.println("----Contact Management System----");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice : ");
            int Choice = scanner.nextInt();
            scanner.nextLine();

            switch (Choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    // searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Existing the contact management system");
                    break;

                default:
                    System.out.println("Invalid choice. please enter a valid choice");
                    break;
            }

        }
        scanner.close();
    }

    public void addContact() {
        System.out.println("--- Add Contact---");
        System.out.println("Enter Name");
        String Name = scanner.nextLine();
        System.out.println("Enter Email:");
        String Email = scanner.nextLine();
        System.out.println("Enter phone No");
        String PhoneNo = scanner.nextLine();
        
        String insertQuery = "INSERT INTO data (Name,Email,PhoneNo) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set values for the parameters in the prepared statement
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Email);
            preparedStatement.setString(3, PhoneNo);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    public void deleteContact() {
        System.out.println("--- Delete Contact ---");
        System.out.println("Enter Name to delete:");
        String nameToDelete = scanner.nextLine();

        String deleteQuery = "DELETE FROM data WHERE Name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            // Set the value for the parameter in the prepared statement
            preparedStatement.setString(1, nameToDelete);

            // Execute the delete query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("No data found for the given name. Nothing deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewContact() {
        System.out.println("--- Retrieve Contacts ---");

        String selectQuery = "SELECT Name, Email, PhoneNo FROM data";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            // Execute the select query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String phoneNo = resultSet.getString("PhoneNo");

                System.out.println("Name: " + name + ", Email: " + email + ", Phone No: " + phoneNo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}