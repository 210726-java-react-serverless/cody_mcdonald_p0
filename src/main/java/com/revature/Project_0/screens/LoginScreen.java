package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws IOException {
        String un,pw;


        System.out.println("Please enter your username:");
        un  = consoleReader.readLine();
        System.out.println("Please enter your password:");
        pw = consoleReader.readLine();
        System.out.println("Validating....");
        //TODO replace this with actual validation
        if(un.equals("admin")){
            System.out.println("Woops, didn't implement this yet. Come on in!");
            router.navigate("/faculty-home");
        }else if(un.equals("student")){
            System.out.println("Woops, didn't implement this yet. Come on in!");
            router.navigate("/student-home");
        }else {
            System.out.println("Invalid credentials, returning to home...");
            router.navigate("/welcome");
        }




        //TODO prompt user for username+password, validate it, then compare it against the database.
        //  Check if the user is an Admin or a Student.
        //  Lastly, log the user into the proper dashboard if there are no issues.
        //      Not finally because that would log them in anyways. :)


    }
}
