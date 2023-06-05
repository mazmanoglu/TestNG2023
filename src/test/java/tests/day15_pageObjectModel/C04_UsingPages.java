package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_UsingPages {
    // go to amazon webpage
    // create 3 test method
    // On each method make search for Nutella, Java and Bicycle
    // Test the results contain these words.
    AmazonHomePage amazonHomePage = new AmazonHomePage();

    @Test (dependsOnMethods = "bicycleTest")
    public void nutellaTest() {
        amazonHomePage.searchBoxElement.clear();
        amazonHomePage.searchBoxElement.sendKeys("Nutella" + Keys.ENTER);
        String actualResultText = amazonHomePage.searchResultTextElement.getText();
        String expectedResultForNutella = "Nutella";
        Assert.assertTrue(actualResultText.contains(expectedResultForNutella));
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "bicycleTest")
    public void javaTest() {
        amazonHomePage.searchBoxElement.clear();
        amazonHomePage.searchBoxElement.sendKeys("Java" + Keys.ENTER);
        String actualResultText = amazonHomePage.searchResultTextElement.getText();
        String expectedResultForJava = "Java";
        Assert.assertTrue(actualResultText.contains(expectedResultForJava));
        ReusableMethods.wait(2);
    }

    @Test
    public void bicycleTest() {
        Driver.getDriver().get("https://www.amazon.com");
        amazonHomePage.searchBoxElement.sendKeys("bicycle" + Keys.ENTER);
        String actualResultText = amazonHomePage.searchResultTextElement.getText();
        String expectedResultForBicycle = "bicycle";
        Assert.assertTrue(actualResultText.contains(expectedResultForBicycle));
        ReusableMethods.wait(2);
    }
}
