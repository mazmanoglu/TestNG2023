package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonHomePage {
    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // search box on amazon
    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBoxElement;

    // result text element on amazon search
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement searchResultTextElement;

}
