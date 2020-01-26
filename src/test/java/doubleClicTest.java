import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class doubleClicTest extends BaseSeleniumTest {
    @Test
    public void doubleClickTest() {
        SeleniumHelper helper = new SeleniumHelper(driver);

        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\DoubleClick.html");
        WebElement doubleClickButton = driver.findElement(By.id("bottom"));

        Actions action = new Actions(driver);
        action.moveToElement(doubleClickButton).doubleClick().build().perform();
        //Alternatywne doubleClick
        //action.doubleClick(doubleClickButton).build().perform();

        helper.takeScreenShot();
        Assert.assertTrue(driver.getWindowHandles().size()>1);

    }
}
