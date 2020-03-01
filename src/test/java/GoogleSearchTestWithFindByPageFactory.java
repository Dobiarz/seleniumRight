import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseSeleniumTest;

public class GoogleSearchTestWithFindByPageFactory extends BaseSeleniumTest {

    @FindBy(name = "q")
    private WebElement searchInput;
    // Wyszukanie listy elementów z name="q"
    //private List<WebElement> searchInput
    //searchInput.get(0).sendKeys("Selenium");

    @Test
    public void googleSearchTestWithFindByPageFactory() {

        SeleniumHelper helper = new SeleniumHelper(driver);
        //inicjalizuje pole oznaczone @FindBy, this-klasa okreslająca strone na ktorej program ma dzialać
        PageFactory.initElements(driver, this);
        driver.get("http://www.google.com");
        searchInput.sendKeys("Selenium");
        helper.takeScreenShot();
        searchInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
        helper.takeScreenShot();
        Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");


    }
}
