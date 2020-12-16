package com.example.listview;

public class Student {

    String sName;
    String sContact;

    public Student(String sName, String sContact) {
        this.sName = sName;
        this.sContact = sContact;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsContact() {
        return sContact;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact;
    }
}
