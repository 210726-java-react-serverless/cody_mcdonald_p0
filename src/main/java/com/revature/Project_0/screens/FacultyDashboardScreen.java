package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class FacultyDashboardScreen extends Screen{

    public FacultyDashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("FacultyHomeScreen", "/faculty-home", consoleReader, router);
    }

    @Override
    public void render() throws IOException {

        System.out.println("Faculty Screen\n\n" +
                "Welcome, admin.\n" +//TODO +username
                "Please select an option.\n" +
                "1)\n" +
                "2)\n" +
                "3)\n" +
                "4)\n");

        router.navigate("/welcome");

        //TODO Print available user options

    }
}
