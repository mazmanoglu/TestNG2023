package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // sign up / login
    @FindBy(linkText = "Signup / Login")
    public WebElement signUpLoginElement;

    // login to your account text
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountTextElement;

    // email address
    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailLoginBoxElement;

    // password
    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordBoxElement;

    //login button
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButtonElement;

    //success text
    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loginAsUserText;
}
