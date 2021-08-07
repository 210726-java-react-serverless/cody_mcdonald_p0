package com.revature.Project_0.screens;

import com.revature.Project_0.exceptions.InvalidEntryException;
import com.revature.Project_0.util.ScreenRouter;
import com.revature.Project_0.util.inputValidator;
import org.omg.CORBA.DynAnyPackage.Invalid;

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

        System.out.print("\nEmail\n*Must be a valid email address: ");
        String email = consoleReader.readLine();

        System.out.print("\nUsername:\n*Must be between 4 and 25 characters: ");
        String username = consoleReader.readLine();

        System.out.print("\nPassword:\n*Must be a minimum of 8 characters. ");
        String password = consoleReader.readLine();


        inputValidator.userEntryValidator(firstName, lastName, email, username, password);
        System.out.println("User registered!"); //TODO Actually register user.

        router.navigate("/welcome");


        System.out.println("Under construction, please come again!");


        //TODO prompt user for information, validate it, then compare it against the database.
        //  Lastly, add the user to the database if there are no issues.
        //      Not finally because that would add it anyways. :)

    }
}
