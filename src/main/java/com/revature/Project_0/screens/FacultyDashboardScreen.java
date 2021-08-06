package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyDashboardScreen extends Screen{

    public FacultyDashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("FacultyHomeScreen", "/faculty-home", consoleReader, router);
    }

    @Override
    public void render() {

        System.out.println("eeeeeee");
        router.navigate("/welcome");

        //TODO Print available user options

    }
}
