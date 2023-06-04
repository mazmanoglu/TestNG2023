package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C02_UsingDriver {
    // create a test method
    // go to amazon webpage, verify the title contains "Amazon"
    // search nutella, and verify results contain "nutella"
    // go to wisequarter, and verify the url contains "wisequarter"

    @Test
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedWord = "Amazon";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedWord),"title does not contain 'Amazon'");


        WebElement searchBoxElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("nutella"+ Keys.ENTER);
        WebElement resultTextElement = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedResult = "nutella";
        softAssert.assertTrue(resultTextElement.getText().contains(expectedResult),"search result cannot contain 'nutella'");


        Driver.getDriver().get("https://www.wisequarter.com");
        String expectedUrlWord = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlWord),"URL does not contain 'wisequarter'");


        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }
}