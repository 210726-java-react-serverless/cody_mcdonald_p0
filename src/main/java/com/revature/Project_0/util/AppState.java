package com.revature.Project_0.util;

import com.revature.Project_0.repositories.CourseRepository;
import com.revature.Project_0.repositories.UserRepository;
import com.revature.Project_0.services.CourseService;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Create app components
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        CourseRepository courseRepo = new CourseRepository();
        CourseService courseService = new CourseService(courseRepo);

        //Instantiate Screens
        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new AddCourseScreen(consoleReader, router))
                .addScreen(new CourseRegistrationScreen(consoleReader, router, courseService))
                .addScreen(new EditCourseScreen(consoleReader, router))
                .addScreen(new FacultyDashboardScreen(consoleReader, router))
                .addScreen(new JoinCourseScreen(consoleReader, router, courseService))
                .addScreen(new RegisteredCoursesScreen(consoleReader, router, courseService))
                .addScreen(new RemoveCourseScreen(consoleReader, router, courseService))
                .addScreen(new StudentDashboardScreen(consoleReader, router))
                .addScreen(new LoginScreen(consoleReader, router))
                .addScreen(new ViewCoursesScreen(consoleReader, router, courseService))
                .addScreen(new newStudentScreen(consoleReader, router));
        ;
        //TODO Kinda ugly and unnecessary to load all screens at once
        //  implement a screen singleton factory that loads screens as needed later


    }

    public void startup() {
        router.navigate("/welcome");        //display welcome screen on startup

        while (appRunning) {                    //while the app is running, render the current screen
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void setAppRunning(boolean appRunning) {
        System.out.println("Shutting down...");
        AppState.appRunning = appRunning;
    }
}
