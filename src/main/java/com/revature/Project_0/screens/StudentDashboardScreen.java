package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentDashboardScreen extends Screen{

    public StudentDashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentHomeScreen", "/new-course", consoleReader, router);
    }

    @Override
    public void render() {
        System.out.println("Welcome, user."); //TODO "Welcome, "+studentName
        System.out.println("Please select an option."+
                "\n1) View available courses." +
                "\n2) Register for a course." +
                "\n3) View registered courses" +
                "\n4) Cancel course registration." +
                "\n5) Log out.");

        //TODO Take user input, validate it, and perform operations as expected with a switch

    }
}
