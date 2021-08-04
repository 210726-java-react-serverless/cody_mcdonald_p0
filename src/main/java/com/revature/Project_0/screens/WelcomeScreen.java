package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen {


    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() {
        // Output welcome message and display options.
        String menu = "\nWelcome to the Student Management Console.\n" +
                "1) Faculty Login\n" +
                "2) Student Login\n" +
                "3) New Student\n" +
                "4) Exit application\n" +
                "> ...";

        System.out.print(menu);
    }



}
