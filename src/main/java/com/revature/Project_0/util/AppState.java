package com.revature.Project_0.util;

import com.revature.Project_0.repositories.UserRepository;
import com.revature.Project_0.services.UserService;
import com.revature.Project_0.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Create app components
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        //Instantiate Screens
        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new AddCourseScreen(consoleReader, router))
                .addScreen(new CourseRegistrationScreen(consoleReader, router, userService))
                .addScreen(new EditCourseScreen(consoleReader, router));
        ;
        //TODO Kinda ugly and unnecessary
        // maybe implement screens as eager singletons or a screen factory using lazy singletons?


    }

    public void startup() {
        router.navigate("/welcome");        //display welcome screen on startup

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
