import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BabyManagerTest {

    @Test
    public void feedingsTest(){
        String drirverPath = "/home/tomasz/Desktop/KursSelenium/seleniumRight/src/main/resources/executables/divers/chromedriver";
        System.setProperty("webdriver.chrome.driver", drirverPath);

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://babymanager-env.sjwux4bm8p.eu-central-1.elasticbeanstalk.com/");

        WebElement feedingButton = driver.findElement(By.partialLinkText("Feeding"));
        feedingButton.click();
    }
}
