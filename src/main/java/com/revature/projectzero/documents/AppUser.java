package com.revature.projectzero.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


// AppUser POJO
// TODO: Map BsonProperties

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUser {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private boolean isFaculty; //boolean to determine if the user is faculty or student

    //Jackson requires a no-args constructor
    public AppUser(){ super(); }

    public AppUser(String fn, String ln, String email, String un, String pw, boolean userType ){
        this.firstName = fn;
        this.lastName = ln;
        this.email = email;
        this.username = un;
        this.password = pw;
        this.isFaculty = userType;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFaculty() {
        return isFaculty;
    }

    public void setFaculty(boolean adminUser) {
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

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, username, password, isFaculty);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj ) return true;
        else if (obj == null || getClass() != obj.getClass()) return false;
        AppUser appUser = (AppUser) obj;
        return Objects.equals(id, appUser.id) && Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(email, appUser.email) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(isFaculty, appUser.isFaculty);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isFaculty=" + isFaculty +
                '}';
    }
}
