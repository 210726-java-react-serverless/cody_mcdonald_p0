package com.revature.Project_0.services;

import com.revature.Project_0.exceptions.InvalidEntryException;
import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidEntryException("Invalid user data provided!");
        }

        return userRepo.save(newUser);

    }

    public AppUser login(String username, String password) {
        return null;
    }


    /*Validating that all entries are:
     * Not null or empty.
     *
     *
     */

    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }
}
