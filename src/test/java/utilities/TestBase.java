package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    public void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    public void takeScreenshot(String pictureName) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd-HHmmss");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sceenshotFile = new File("target/screenshots/"+pictureName+ldt.format(dtf)+".png");

        File temporaryFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporaryFile,sceenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
