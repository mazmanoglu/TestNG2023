package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import utilities.Driver;

public class C03_UsingPages {

    /*
        Pages classes are created, to locate the webElements that we want to on a web page and then use them when we need them.
        In order to access webElements located in Pages classes, we create an object (make an instance) from the relevant page class in our test class.
     */

    @Test
    public void test01(){
        // go to amazon webpage
        // search Nutella,
        // test result text contains "Nutella"

        Driver.getDriver().get("https://www.amazon.com");
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        amazonHomePage.searchBoxElement.sendKeys("nutella"+ Keys.ENTER);

        String actualResultText = amazonHomePage.searchResultTextElement.getText();
        String expectedResult = "Nutella";
        Assert.assertTrue(actualResultText.contains(expectedResult));

        Driver.closeDriver();
    }
}
