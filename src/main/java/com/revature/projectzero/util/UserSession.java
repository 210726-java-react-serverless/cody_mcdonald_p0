package com.revature.projectzero.util;

import com.revature.projectzero.documents.AppUser;

public class UserSession {

    private AppUser currentUser;

    public boolean isActive() {
        return currentUser != null;
    }

    // Clear out user's data when they log off
    public void closeSession() {
        setCurrentUser(null);
    }

    // Getters and setters
    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }

}
