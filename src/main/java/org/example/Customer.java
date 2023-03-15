package org.example;

public class Customer {
    private int Id;
    private String Name;
    private String Address;
    private String Email;

    //empty constructor
    public Customer() {
    }

    //Constructor
    public Customer(int id, String name, String address, String email) {
        Id = id;
        Name = name;
        Address = address;
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
