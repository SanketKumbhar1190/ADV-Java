package com.shop.beans;

public class User {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String city;
    
    // Default constructor
    public User() {}
    
    // Getters
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getCity() {
        return city;
    }
    
    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
}
