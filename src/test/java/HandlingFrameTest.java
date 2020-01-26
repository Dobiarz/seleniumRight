
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HandlingFrameTest extends BaseSeleniumTest {



    @Test
    public void handlingFramesTest() {

        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\iFrameTest.html");

        driver.switchTo().frame(0);

        WebElement clickButton = driver.findElement(By.id("clickOnMe"));
        clickButton.click();
        driver.switchTo().alert().accept();
        //Ponowne przelaczenie na pierwotny html
        driver.switchTo().defaultContent();
        List<WebElement> headers = driver.findElements(By.tagName("h1"));
        System.out.println(headers.size());
        headers.forEach(webElement-> System.out.println(webElement.getText()));
        // Alternatywne sposob wydruku na konsole
        System.out.println(headers.get(0).getText());


    }

}
