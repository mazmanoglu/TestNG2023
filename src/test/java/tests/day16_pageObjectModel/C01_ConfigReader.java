package tests.day16_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ConfigReader {

    @Test
    public void test01() {
        // go to amazon webpage
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        // make search for Nutella
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        amazonHomePage.searchBoxElement.sendKeys(ConfigReader.getProperty("amazonSearchText") + Keys.ENTER);
        // Test the result contains "Nutella"
        String expectedWord = ConfigReader.getProperty("amazonSearchText");
        String actualSearchResult = amazonHomePage.searchResultTextElement.getText();
        Assert.assertTrue(actualSearchResult.contains(expectedWord));

        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
