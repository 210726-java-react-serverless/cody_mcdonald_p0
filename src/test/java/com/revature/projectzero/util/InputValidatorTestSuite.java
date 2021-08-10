package com.revature.projectzero.util;

import com.revature.projectzero.documents.AppUser;
import com.revature.projectzero.util.exceptions.InvalidEntryException;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class InputValidatorTestSuite {

    private AppUser mockAppUser;

    @Before
    public void setup(){
        mockAppUser = mock(AppUser.class);
    }
    @After
    public void cleanUp(){
        mockAppUser = null;
    }

    @Test
    public void userEntryValidator_throwsException_whenGivenBlankValues(){

        try {
            InputValidator.userEntryValidator("", "", "", "", "");
            fail("This process will fail.");
        }catch (InvalidEntryException e){
            assertEquals(InvalidEntryException.class, e.getCause().getClass());
        }
    }

}




