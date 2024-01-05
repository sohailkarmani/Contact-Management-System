
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact_Manager {
    private List<Contact> contacts;
    private Scanner scanner;

    public Contact_Manager() {
        contacts = new ArrayList<>();
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
                    searchContact();
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
        String name = scanner.nextLine();
        System.out.println("Enter Email:");
        String Email = scanner.nextLine();
        System.out.println("Enter phone No");
        String phoneNo = scanner.nextLine();
        Contact contact = new Contact(name, Email, phoneNo);
        contacts.add(contact);
        System.out.println("Contact added successfully");
    }

    private void viewContact() {
        System.out.println("---View Contacts---");
        if (contacts.isEmpty()) {
            System.out.println("No contacts available");

        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void searchContact() {
        System.out.println("----- Search Contact -----");
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact found: " + contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private void deleteContact() {
        System.out.println("----- Delete Contact -----");
        System.out.print("Enter name to delete: ");
        String deleteName = scanner.nextLine();
        boolean removed = contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(deleteName));

        if (removed) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }


    public static void main(String[] args) {
        Contact_Manager app = new Contact_Manager();
        app.start();
    }

}
