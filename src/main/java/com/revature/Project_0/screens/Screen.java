package com.revature.Project_0.screens;

import com.revature.Project_0.util.ScreenRouter;

import java.io.BufferedReader;

public abstract class Screen {

    protected String name;  //instantiate parameters
    protected String route;
    protected BufferedReader consoleReader;
    protected ScreenRouter router;

    public Screen(String name, String route, BufferedReader consoleReader, ScreenRouter router) { // for initializing parameters in subclasses
        this.name = name;
        this.route = route;
        this.consoleReader = consoleReader;
        this.router = router;
    }

    public String getName() {
        return name;
    } //getters

    public String getRoute() {
        return route;
    }

    public abstract void render() throws Exception; //to be modified by subclasses, executes the print and input for the designated screen

}