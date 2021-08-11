package com.revature.projectzero;


import com.revature.projectzero.util.AppState;

/*
 * Console-Based Student Management Console for Project 0
 *      Written by Cody McDonald
 *
 * Faculty Members may:
 *  Add new classes
 *  Change registration details for a class
 *  Remove a class from the registration catalog
 *
 * Students may:
 *  Register a new account
 *  Login with existing credentials
 *  View classes available for registration
 *  Register for an open and available class
 *  Cancel registration for a class (if within window)
 *  View the class(es) they have registered for
 *
 *
 */



public class CourseManagementApp {

    // Main method creates an AppState object and uses it to run the startup method to build the project.
    public static void main(String[] args) {

        AppState app = new AppState();
        app.startup();

    }

}