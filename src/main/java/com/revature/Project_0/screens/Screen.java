package com.revature.Project_0.screens;

public abstract class Screen {

    protected String name;  //instantiate parameters
    protected String route;

    public Screen(String name, String route) { // for initializing parameters in subclasses
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    } //getters

    public String getRoute() {
        return route;
    }

    public abstract void render(); //to be modified by subclasses

}