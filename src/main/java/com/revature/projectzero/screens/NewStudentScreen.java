package com.revature.projectzero.screens;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.documents.UserCourses;
import com.revature.projectzero.services.UserCoursesService;
import com.revature.projectzero.services.UserService;
import com.revature.projectzero.util.ScreenRouter;
import com.revature.projectzero.util.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.BufferedReader;


public class NewStudentScreen extends Screen {

    private final Logger logger = LogManager.getLogger(NewStudentScreen.class);
    private final UserService userService;
    private final UserCoursesService courseListService;

    public NewStudentScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService,
                            UserCoursesService userCoursesService) {
        super("NewStudentScreen", "/new-student", consoleReader, router);
        this.userService = userService;
        this.courseListService = userCoursesService;
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
            // Validate that the user followed the defined guidelines for each field.
            InputValidator.userEntryValidator(firstName, lastName, email, username, password);
            AppUser newUser = new AppUser(firstName, lastName, email, username, password, false);
            UserCourses newUserCourseList = new UserCourses(username);
            userService.register(newUser);
            courseListService.initialize(newUserCourseList);
            System.out.println("Student registered!");
            logger.info("New student with the username "+ username +" registered and added to database.");
            router.navigate("/student-home");
        }catch (Exception e) {
            System.out.println("User not registered!\n");
            logger.error("User registration failed. Reason:");
            logger.error(e.getMessage());
            router.navigate("/welcome");
        }


    }
}
