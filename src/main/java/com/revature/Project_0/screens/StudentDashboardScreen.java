package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentDashboardScreen extends Screen{

    public StudentDashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentHomeScreen", "/new-course", consoleReader, router);
    }

    @Override
    public void render() {

        //TODO Print available user options

    }
}
