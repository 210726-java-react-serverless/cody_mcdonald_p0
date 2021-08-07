package com.revature.Project_0.screens;

import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.util.ScreenRouter;
import com.revature.Project_0.util.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.BufferedReader;
import java.io.IOException;


public class newStudentScreen extends Screen {

    private final Logger logger = LogManager.getLogger(newStudentScreen.class);
    private final UserService userService;

    public newStudentScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("newStudentScreen", "/new-student", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
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

        try{
            InputValidator.userEntryValidator(firstName, lastName, email, username, password);
            AppUser newUser = new AppUser(firstName, lastName, email, username, password, false);
            userService.register(newUser);
            System.out.println("Student registered!");
            router.navigate("/student-home");
        }catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug("User not registered!");
            router.navigate("/welcome");
        }


    }
}
