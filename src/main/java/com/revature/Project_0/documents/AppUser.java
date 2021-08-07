package com.revature.Project_0.documents;

public class AppUser {

    private boolean isFaculty; //boolean to determine if the user is faculty or student
    private String id, firstName, lastName, email, username, password;

    public AppUser(String fn, String ln, String email, String un, String pw, boolean userType ){
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.username = un;
        this.password = pw;
        this.isFaculty = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdminUser() {
        return isFaculty;
    }

    public void setAdminUser(boolean adminUser) {
        this.isFaculty = adminUser;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
