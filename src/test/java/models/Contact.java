package models;

import org.testng.annotations.Test;

//POJO - PLAIN OLD JAVA OBJECT
public class Contact {
    String firstName;
    String lastName;
    String accountName;
    String phone;
    String mobile;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public Contact(String firstName, String lastName, String accountName, String phone, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountName = accountName;
        this.phone = phone;
        this.mobile = mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
