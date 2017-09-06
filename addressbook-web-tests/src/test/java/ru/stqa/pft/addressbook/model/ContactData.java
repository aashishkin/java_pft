package ru.stqa.pft.addressbook.model;

public class ContactData {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;
    private final String mobile;
    private final String workPhone;

    public ContactData(String firstName, String lastName, String address, String email, String mobile, String workPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.workPhone = workPhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkPhone() {
        return workPhone;
    }
}
