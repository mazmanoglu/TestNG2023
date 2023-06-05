package tests.day15_pageObjectModel;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_UsingPages {

    FacebookPage facebook = new FacebookPage();
    Faker faker = new Faker();

    @Test
    public void test01(){
        // go to facebook
        // locate the email, password and log in button using POM
        // Use Faker class and write a username and password, then click log in button
        // test failed message is displayed

        Driver.getDriver().get("https://www.facebook.com");
        facebook.facebookAcceptCookies.click();
        facebook.facebookUsernameBoxElement.sendKeys(faker.internet().emailAddress());
        ReusableMethods.wait(1);
        facebook.facebookPasswordBoxElement.sendKeys(faker.internet().password(5,12));
        ReusableMethods.wait(1);
        facebook.facebookLoginButtonElement.click();
        Assert.assertTrue(facebook.facebookFailedMessage.isDisplayed());
        Driver.closeDriver();
    }
}