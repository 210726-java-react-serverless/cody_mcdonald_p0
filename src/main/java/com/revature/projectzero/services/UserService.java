package com.revature.projectzero.services;

import com.revature.projectzero.util.UserSession;
import com.revature.projectzero.util.exceptions.AuthenticationException;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.repositories.UserRepository;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;

public class UserService {

    private final UserRepository userRepo;
    private final UserSession session;

    public UserService(UserRepository userRepo, UserSession session) {
        this.userRepo = userRepo;
        this.session = session;
    }

    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser))
        {
            throw new InvalidEntryException("Invalid user data provided!");
        }

        if (userRepo.findUserByUsername(newUser.getUsername()) != null)
        {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        if (userRepo.findUserByEmail(newUser.getEmail()) != null)
        {
            throw new ResourcePersistenceException("Provided email is already taken!");
        }

        session.setCurrentUser(newUser);
        return userRepo.save(newUser);

    }

    public AppUser login(String username, String password) {

        AppUser authUser = userRepo.findUserByCredentials(username, password);

        if (authUser == null) {
            throw new AuthenticationException("Invalid credentials provided!");
        }

        session.setCurrentUser(authUser);

        return authUser;
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

    public UserSession getSession() {
        return session;
    }
}
