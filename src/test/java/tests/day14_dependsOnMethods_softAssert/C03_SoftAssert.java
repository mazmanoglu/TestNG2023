package tests.day14_dependsOnMethods_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssert {

    @Test
    public void hardAssertionTest(){
        // Check a given password meets the requirements.
        /*
        - On the Assertion operations, the code stops running at the first error (stop execution)
        - All methods in Assert class are static, that's why we can call them like "className.methodName"
         */

        String password = "Javaisbest";
        //  - first letter must be uppercase
        boolean firstLetterControl = password.charAt(0)>='A' && password.charAt(0)<='Z';
        Assert.assertTrue(firstLetterControl,"First letter must be UPPERCASE");

        //  - last letter must be lowercase
        boolean lastLetterControl = password.charAt(password.length()-1)>='a' && password.charAt(password.length()-1)<='z';
        Assert.assertTrue(lastLetterControl, "Last letter must be lowercase");

        //  - must not contain spaces
        Assert.assertFalse(password.contains(" "), "Password must not contains space");

        //  - must be at least 8 characters
        Assert.assertTrue(password.length()>=8,"Password must be at least 8 character");

        // If password requires all conditions, write "password successfully saved";
        System.out.println("Password is successfully saved");
    }

    @Test
    public void softAssertionTest(){
        /*
        The Assert class, which we also use in JUnit, stops working in the first failed assertion and gives an error message.

        If you want it to continue without stopping at the first error and run all the tests until the end, and to report the situation at the end and stop working if any failed, YOU CAN USE the SoftAssert class
        Note--> not all testers are using soft assert

        Methods on SoftAssert are not static. To use methods on SoftAssert class, instant an object.

        Generally
            when we are asked to use hardAssertion, it is written "test"
            when we are asked to use softAssertion, it is written "verify"
         */

        //1- Instant an object from SoftAssert class;
        SoftAssert softAssert = new SoftAssert();

        //2- make all assertions with softAssert object;
        String password = "ava T";
        //  - first letter must be uppercase
        boolean firstLetterControl = password.charAt(0)>='A' && password.charAt(0)<='Z';
        softAssert.assertTrue(firstLetterControl,"First letter must be UPPERCASE");

        //  - last letter must be lowercase
        boolean lastLetterControl = password.charAt(password.length()-1)>='a' && password.charAt(password.length()-1)<='z';
        softAssert.assertTrue(lastLetterControl, "Last letter must be lowercase");

        //  - must not contain spaces
        softAssert.assertFalse(password.contains(" "), "Password must not contains space");

        //  - must be at least 8 characters
        softAssert.assertTrue(password.length()>=8,"Password must be at least 8 character");

        //3- When all test are finished, we have to say "All tests are done, report all assertions".
        // If one of them is failed, code will stop at this point, never shows success message
        softAssert.assertAll();

        // If password requires all conditions, write "password successfully saved";
        System.out.println("Password is successfully saved");
    }
}
