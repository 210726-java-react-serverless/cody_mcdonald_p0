package com.revature.Project_0.util;

import com.revature.Project_0.util.exceptions.InvalidEntryException;
import org.junit.*;



public class InputValidatorTestSuite {


    @Before
    public void beforeEachTest(){}
    @After
    public void afterEachTest(){}

    @Test(expected = InvalidEntryException.class)
    public void userEntryValidator_throwsException_whenGivenBlankValues(){

        Assert.assertThrows(InvalidEntryException.class,() -> {
            InputValidator.userEntryValidator("","","","","");
        });
    }

}



