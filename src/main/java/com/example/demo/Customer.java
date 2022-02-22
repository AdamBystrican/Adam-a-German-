package com.example.demo;

public class Customer {

    public long id;
    private String firstName;
    private String lastName;
    private String contact;

    public Customer(long id,String firstName, String lastName, String contact){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }


    //----------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //----------------------------------------
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //----------------------------------------
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //----------------------------------------
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}
