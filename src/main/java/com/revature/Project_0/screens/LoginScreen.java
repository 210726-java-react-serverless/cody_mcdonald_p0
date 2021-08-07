package com.revature.Project_0.screens;

import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.util.exceptions.AuthenticationException;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends Screen {

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws IOException {
        String un,pw;

        System.out.println("\nUser Login Screen\n" +
                "Please enter your username:");

        un  = consoleReader.readLine();

        System.out.println("Please enter your password:");

        pw = consoleReader.readLine();

        System.out.println("Validating....");

        try {
            AppUser authUser = userService.login(un, pw);
            System.out.println("Login successful!");
            if(authUser.isAdminUser())
                router.navigate("/faculty-home");
            else
                router.navigate("/student-home");

        } catch (AuthenticationException ae) {
            System.out.println("No user found with provided credentials!");
            System.out.println("Navigating back to welcome screen...");
            router.navigate("/welcome");
        }




        //TODO prompt user for username+password, validate it, then compare it against the database.
        //  Check if the user is an Admin or a Student.
        //  Lastly, log the user into the proper dashboard if there are no issues.
        //      Not finally because that would log them in anyways. :)


    }
}
