package com.gosch.addressbook.models;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String nickName;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String group;

    /*
    public ContactData(int id, String firstName, String lastName, String nickName, String mobile, String email, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public ContactData(String firstName, String lastName, String nickName, String mobile, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }
    */

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.homePhone = home;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.workPhone = work;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getAllPhones() {
        return allPhones;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
