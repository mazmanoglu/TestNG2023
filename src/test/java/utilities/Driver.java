package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {

    private Driver(){
        // With Singleton Pattern concept, we created this constructor to prevent creating objects from Driver class.eger
    }
    static WebDriver driver;

    public static WebDriver getDriver(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        FirefoxOptions opes = new FirefoxOptions();
        opes.addArguments("--remote-allow-origins=*");

        EdgeOptions ontes = new EdgeOptions();
        ontes.addArguments("--remote-allow-origins=*");

        // after the update on Boni Garcia's Webdriver file, we solved the problem adding Arguments
        // But here, we see that Firefox can still work without any arguments

        /*
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ops);
        }
        */

        String browser = ConfigReader.getProperty("browser");
        if (driver==null){
            switch (browser){
                /*
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
                    break;
                    // we put this as default
                 */
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(ontes);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }



    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }
    }
}