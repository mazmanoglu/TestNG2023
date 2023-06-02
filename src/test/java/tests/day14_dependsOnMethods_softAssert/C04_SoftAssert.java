package tests.day14_dependsOnMethods_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_SoftAssert extends TestBase {
    @Test
    public void test01() {
        // go to webpage "http://zero.webappsecurity.com/"
        driver.get("http://zero.webappsecurity.com/");

        // click to sign in button
        driver.findElement(By.id("signin_button")).click();

        // write "username" into login box
        driver.findElement(By.id("user_login")).sendKeys("username");

        // write "password" into password box
        driver.findElement(By.id("user_password")).sendKeys("password");

        // click sign in button
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();
        wait(2);

        // go to "pay bills" page under "online banking" menu
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // click "purchase foreign currency" button=
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // choose Eurozone from "currency" dropdown
        WebElement dropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdownMenu);
        select.selectByValue("EUR");

        // use soft assert and verify "Eurozone (Euro)" is chosen
        SoftAssert softAssert = new SoftAssert();
        String expectedOption = "Eurozone (euro)";
        String actualOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOption,expectedOption, "Eurozone cannot be selected");
        takeScreenshot("EurozoneScreenshot");
        // use soft assert and verify dropdown menu has these options "Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)"

        String[] expectedCurrencyArray = {"Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"};
        List<String> expectedCurrencyList = Arrays.asList(expectedCurrencyArray);

        List<WebElement> actualCurrencyElementList = select.getOptions();
        List<String> actualCurrencyList = new ArrayList<>();

        for (WebElement eachElement:actualCurrencyElementList
             ) {
            actualCurrencyList.add(eachElement.getText());
        }


        softAssert.assertEquals(actualCurrencyList,expectedCurrencyList, "The currency lists are different");

        softAssert.assertAll();
        wait(2);
    }
}