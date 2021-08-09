package com.revature.projectzero.util;

/*
 * Class for validating user input to check for:
 *  Empty values,
 *  Password security, (Minimum of 8 characters)
 *  Username length, (Minimum of 4 characters)
 *  invalid username characters, (no symbols in username)
 *
 */

import com.revature.projectzero.util.exceptions.InvalidEntryException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MIN_USERNAME = 4;
    private static final int MIN_PASSWORD = 8;

    // Pattern for username verification, can be any character from a-z, A-Z, and 0-9. No symbols permitted.
    static Pattern usernamePattern = Pattern.compile("[^a-zA-Z0-9]");
    // Pattern for simple email verification.
    static Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");



    // Not meant to be instantiated
    private InputValidator(){}

    // Validator for student registration
    public static void userEntryValidator(String fn, String ln,String em,String un,String pw){

        // Matcher for checking that the username matches the given pattern
        Matcher userMatch = usernamePattern.matcher(un);
        // Matcher for checking that the email matches the given pattern
        Matcher emailMatch = emailPattern.matcher(em);

        if(un.trim().equals("")||pw.trim().equals("")||fn.trim().equals("")||ln.trim().equals("")||
                em.trim().equals(""))
        {
            System.out.println("Fields cannot be blank");
            throw new InvalidEntryException("Blank fields detected.");
        }else if(un.length() < MIN_USERNAME)
        {
            System.out.println("Username must be at least 4 characters.");
            throw new InvalidEntryException("Entered username below the minimum character limit.");
        }else if(pw.length() < MIN_PASSWORD)
        {
            System.out.println("Password must be at least 8 characters.");
            throw new InvalidEntryException("Entered password below the minimum character limit.");
        }else if(userMatch.find())
        {
            System.out.println("Username contains invalid characters.");
            throw  new InvalidEntryException("Invalid characters entered in username.");
        }else if(!emailMatch.find())
        {
            System.out.println("Please enter a valid email address.");
            throw new InvalidEntryException("Invalid email address entered.");
        }


    }
}
