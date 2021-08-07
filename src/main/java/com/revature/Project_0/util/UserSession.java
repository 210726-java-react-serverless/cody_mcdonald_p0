package com.revature.Project_0.util;

import com.revature.Project_0.documents.AppUser;

public class UserSession {

    private AppUser currentUser;

    public boolean isActive() {
        return currentUser != null;
    }

    public void closeSession() {
        setCurrentUser(null);
    }

    //Getters and setters
    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }

}
