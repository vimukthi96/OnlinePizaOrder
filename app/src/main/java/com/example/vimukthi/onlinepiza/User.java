package com.example.vimukthi.onlinepiza;

public class User {

    private String Name;
    private String Passward;
    private String Phone;

    public User() {
    }

    public User(String name, String passward) {
        Name = name;
        Passward = passward;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String passward) {
        Passward = passward;
    }
}
