package ru.stqa.pft.addressbook.model;
import com.google.common.collect.ForwardingSet;

public class ContactData {

    private  String firstName;
    private  String lastName;
    private  String address;
    private  String email;
    private  String mobile;
    private  String workPhone;
    private  String group;

    private String allEmail;
    private String allPhones;

    public ContactData(String firstName, String lastName, String address, String allEmail, String allPhones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.allEmail = allEmail;
        this.allPhones = allPhones;
    }

    public ContactData(String firstName, String lastName, String address, String email, String mobile, String workPhone, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.workPhone = workPhone;
        this.group = group;
    }

    public ContactData() {

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

    public String getGroup() {
        return group;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
}
