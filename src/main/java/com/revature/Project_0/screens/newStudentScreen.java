package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class newStudentScreen extends Screen {

    public newStudentScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("newStudentScreen", "/new-student", consoleReader, router);
    }

    @Override
    public void render() throws IOException {
        System.out.println("\nNew student Registration...\n");

        System.out.print("First name: ");
        String firstName = consoleReader.readLine();

        System.out.print("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.print("\n*Must be a valid email address\nEmail: ");
        String email = consoleReader.readLine();

        System.out.print("\n*Username must be between 4 and 25 characters.\nUsername: ");
        String username = consoleReader.readLine();

        System.out.print("\n*Must include a symbol, a capital letter, and be a minimum of 8 characters.\nPassword: ");
        String password = consoleReader.readLine();

        System.out.println("Under construction, please come again!");
        router.navigate("/welcome");

        //TODO prompt user for information, validate it, then compare it against the database.
        //  Lastly, add the user to the database if there are no issues.
        //      Not finally because that would add it anyways. :)

    }
}
