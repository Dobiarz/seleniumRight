package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {

        System.out.println("Before Test");

        String drirverPath = "/home/tomasz/Desktop/KursSelenium/seleniumRight/src/main/resources/executables/divers/chromedriver";
        System.setProperty("webdriver.chrome.driver", drirverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {

        System.out.println("After Test");
//        driver.quit();

    }
}
