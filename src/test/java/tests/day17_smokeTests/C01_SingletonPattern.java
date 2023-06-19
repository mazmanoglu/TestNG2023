package tests.day17_smokeTests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {
    /*
    The singleton pattern is a concept that prevents or limits the creation of an object from a class.
     */

    @Test
    public void test01(){
        // go to amazon webpage
        // Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        /*
            We can create an object from Driver class like others, and can use class members.

            But in such a use, the preferences we make in the Driver class will be bypassed.

            To avoid such uses, we use Singleton Pattern;

            To prevent the creation of an object from Driver class, make Driver constructor unreachable. Thus, nobody can reach Driver constructor and make an object from that Class.

            To this, we create a Constructor with no visible parameters and make it private.

            We called this SINGLETON PATTERN.

            For example; we create a hospital project, and we want that nobody could change. Put the hospital name in a specific class and make that class as Singleton, thus nobody could change hospital name.
         */

        // Driver driver = new Driver();

    }
}
