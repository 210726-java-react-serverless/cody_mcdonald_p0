package com.revature.projectzero.services;

import com.revature.projectzero.util.InputValidator;
import com.revature.projectzero.util.UserSession;
import com.revature.projectzero.util.exceptions.AuthenticationException;
import com.revature.projectzero.util.exceptions.InvalidEntryException;
import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.repositories.UserRepository;
import com.revature.projectzero.util.exceptions.ResourcePersistenceException;

public class UserService {

    private final UserRepository userRepo;
    private final UserSession session;
    private final InputValidator inputValidator;

    public UserService(UserRepository userRepo, UserSession session, InputValidator inputValidator) {
        this.userRepo = userRepo;
        this.session = session;
        this.inputValidator = inputValidator;
    }

    public AppUser register(AppUser newUser) {

        // Throws exception if entry is invalid
        inputValidator.userEntryValidator(newUser);

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

    public UserSession getSession() {
        return session;
    }
}
