package com.revature.Project_0.util;

/*
 * Class for validating user input to check for:
 *  Empty values,
 *  Password security, (Minimum of 8 characters TODO: One Uppercase, one symbol, and one number.)
 *  Username length, (Greater than 4 characters)
 *  invalid username characters, (no symbols in username)
 *
 */


import com.revature.Project_0.util.exceptions.InvalidEntryException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputValidator {

    // Pattern for username verification, can be any character from a-z, A-Z, and 0-9. No symbols permitted.
    static Pattern usernamePattern = Pattern.compile("[^a-zA-Z0-9]");
    // Pattern for simple email verification.
    static Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");


    // Validator for user registration, validates username, password, and
    public static void userEntryValidator(String fn, String ln,String em,String un,String pw){

        if(un.trim().equals("")||pw.trim().equals("")||fn.trim().equals("")||ln.trim().equals("")||
                em.trim().equals(""))
            throw new InvalidEntryException("Fields cannot be blank.");

        if(un.length() < 4)
            throw new InvalidEntryException("Username must be at least 4 characters.");

        if(pw.length() < 8)
            throw new InvalidEntryException("Password must be at least 8 characters.");

        // Checking that the username matches the given pattern
        Matcher userMatch = usernamePattern.matcher(un);
        if(userMatch.find())
            throw  new InvalidEntryException("Username contains invalid characters.");

        Matcher emailMatch = emailPattern.matcher(em);
        if(!emailMatch.find())
            throw new InvalidEntryException("Please enter a valid email address.");


    }


}
