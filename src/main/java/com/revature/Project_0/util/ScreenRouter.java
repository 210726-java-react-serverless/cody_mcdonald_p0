package com.revature.Project_0.util;

import com.revature.Project_0.exceptions.ScreenNotFoundException;
import com.revature.Project_0.screens.Screen;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Screen currentScreen;
    //HashSet of screens for storing activated screens
    private Set<Screen> screens = new HashSet<>();
    //ArrayDeque to be used as a stack for "back" or "cancel" functionality.
    private ArrayDeque<Screen> previousScreens;

    public ScreenRouter(){ previousScreens = new ArrayDeque<Screen>();} //instantiate history in default cons

    //Method to add a screen to the hashset.
    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    // Retrieves a route, then sets the current screen to the screen with a matching route by using Collection.Stream()
    // to create a stream of Screen objects, filtering it to screens with the defined route, and finally
    // returning the first instance of a stream with that route.
    public void navigate(String route) {
        if(currentScreen != null) {
            previousScreens.push(currentScreen); //pushes the current screen onto the top of the stack
        }
        currentScreen = screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new);
    }

    public void goBack() throws ScreenNotFoundException{
        if(previousScreens.size() == 0){ throw new ScreenNotFoundException();}
        currentScreen = previousScreens.pop();
    }


    // Cleanses the history to free up memory after a user logs and to prevent potential security risks.
    public void deleteHistory(){ previousScreens.clear(); }

    // Getters
    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public ArrayDeque<Screen> getPreviousScreens() { return previousScreens; }
}
