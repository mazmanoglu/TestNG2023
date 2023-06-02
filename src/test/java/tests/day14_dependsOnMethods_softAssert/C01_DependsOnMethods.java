package tests.day14_dependsOnMethods_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C01_DependsOnMethods extends TestBaseClass {

    // create 3 test methods
    // first test method = named amazon, go to amazon webpage and test it
    // second test method = nutella, search nutella on amazon webpage and test results contain nutella
    // third test method = searchResultTest, test the result is bigger than 100

    /*
    dependsOnMethods= connects two test methods.
    In this way, if the being connected test fails, the connected test is ignored and will never run.
     */

    @Test(priority = 1)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(priority = 2, dependsOnMethods = "amazonTest")
    public void nutellaTest(){
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella"+ Keys.ENTER);
        // if we search another word instead Nutella, searchResultTest() would be ignored

        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedResultText = "Nutella";
        String actualResultText = resultTextElement.getText();
        Assert.assertTrue(actualResultText.contains(expectedResultText));
    }

    @Test(priority = 3, dependsOnMethods = "nutellaTest")
    public void searchResultTest(){
        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResultText = resultTextElement.getText(); // 1-48 of 114 results for "nutella"
        int indexOf = actualResultText.indexOf("of");
        int indexResults = actualResultText.indexOf("result");

        String resultNumberAsString = actualResultText.substring(indexOf+3,indexResults-1);
        int resultNumberAsInteger = Integer.parseInt(resultNumberAsString);
        int expectedMinResultNumber = 100;

        Assert.assertTrue(resultNumberAsInteger>expectedMinResultNumber);


    }
}
