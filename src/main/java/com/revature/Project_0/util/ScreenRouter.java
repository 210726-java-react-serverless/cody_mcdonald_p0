package com.revature.Project_0.util;

import com.revature.Project_0.exceptions.ScreenNotFoundException;
import com.revature.Project_0.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Screen currentScreen;
    private Screen previousScreen;
    private Set<Screen> screens = new HashSet<>(); //hashset of screens for retrieval

    public ScreenRouter addScreen(Screen screen) { //adds screens to the hashset
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        currentScreen = screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new);
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }
}
