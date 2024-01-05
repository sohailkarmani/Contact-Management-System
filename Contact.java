public class Contact {
    private String name;
    private String Email;
    private String phoneNo;

    // Constructor
    public Contact(String name, String Email, String phoneNo) {
        this.name = name;
        this.Email = Email;
        this.phoneNo = phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    // toString method for representation
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNo + '\'' +
                ", email='" + Email + "}";
    }

}