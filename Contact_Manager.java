
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                    // viewContact();
                    break;
                case 3:
                    // searchContact();
                    break;
                case 4:
                    // deleteContact();
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

    // public void addContact() {
    // System.out.println("--- Add Contact---");
    // System.out.println("Enter Name");
    // String Name = scanner.nextLine();
    // System.out.println("Enter Email:");
    // String Email = scanner.nextLine();
    // System.out.println("Enter phone No");
    // String PhoneNo = scanner.nextLine();
    // Contact contact = new Contact(Name, Email, PhoneNo);
    // //contacts.add(contact);

    // // Insert data into the database
    // try {
    // // SQL query to insert data
    // String insertQuery = "INSERT INTO data (Name, Email, PhoneNo) VALUES (?, ?,
    // ?)";

    // // PreparedStatement preparedStatement =
    // connection.prepareStatement(insertQuery);
    // try (PreparedStatement preparedStatement =
    // connection.prepareStatement(insertQuery)) {
    // // Set values for the parameters in the prepared statement
    // preparedStatement.setString(1, Name);
    // preparedStatement.setString(2, Email);
    // preparedStatement.setString(3, PhoneNo);

    // // Execute the insert query
    // int rowsAffected = preparedStatement.executeUpdate();

    // if (rowsAffected > 0) {
    // System.out.println("Data inserted successfully!");
    // } else {
    // System.out.println("Failed to insert data!");
    // }
    // }catch(SQLException e){
    // e.printStackTrace();

    // }

    // System.out.println("Contact added successfully");

    // }

    // // private void viewContact() {
    // // System.out.println("---View Contacts---");
    // // if (contacts.isEmpty()) {
    // // System.out.println("No contacts available");

    // // } else {
    // // for (Contact contact : contacts) {
    // // System.out.println(contact);
    // // }
    // // }
    // // }

    // // private void searchContact() {
    // // System.out.println("----- Search Contact -----");
    // // System.out.print("Enter name to search: ");
    // // String searchName = scanner.nextLine();
    // // boolean found = false;

    // // for (Contact contact : contacts) {
    // // if (contact.getName().equalsIgnoreCase(searchName)) {
    // // System.out.println("Contact found: " + contact);
    // // found = true;
    // // break;
    // // }
    // // }

    // // if (!found) {
    // // System.out.println("Contact not found.");
    // // }
    // // }

    // // private void deleteContact() {
    // // System.out.println("----- Delete Contact -----");
    // // System.out.print("Enter name to delete: ");
    // // String deleteName = scanner.nextLine();
    // // boolean removed = contacts.removeIf(contact ->
    // contact.getName().equalsIgnoreCase(deleteName));

    // // if (removed) {
    // // System.out.println("Contact deleted successfully.");
    // // } else {
    // // System.out.println("Contact not found.");
    // // }

    // }

    public void addContact() {
        System.out.println("--- Add Contact---");
        System.out.println("Enter Name");
        String Name = scanner.nextLine();
        System.out.println("Enter Email:");
        String Email = scanner.nextLine();
        System.out.println("Enter phone No");
        String PhoneNo = scanner.nextLine();
        // Contact contact = new Contact(Name, Email, PhoneNo);
        // contacts.add(contact);

        // SQL query to insert data
        // String insertQuery = "INSERT INTO data (Name, Email, PhoneNo) VALUES (?, ?,
        // ?)";
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

        // } catch (SQLException e) {
        // System.out.println("Connection to the database failed!");
        // e.printStackTrace();
        // }

    }

}