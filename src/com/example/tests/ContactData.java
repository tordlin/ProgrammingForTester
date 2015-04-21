package com.example.tests;

public class ContactData {
    public String name;
    public String surname;
    public String address;
    public String homeNumber;
    public String mobileNumber;
    public String workNumber;
    public String email1;
    public String email2;
    public String bday;
    public String bmonth;
    public String byear;
    public String groupName;
    public String secondaryAddress;
    public String secondaryPhone;

    public ContactData(String name, String surname, String address, String homeNumber, String mobileNumber, String workNumber, String email1, String email2, String bday, String bmonth, String byear, String groupName, String secondaryAddress, String secondaryPhone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.email1 = email1;
        this.email2 = email2;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.groupName = groupName;
        this.secondaryAddress = secondaryAddress;
        this.secondaryPhone = secondaryPhone;
    }

    public ContactData() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }
}
