import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleSerchTest extends BaseSeleniumTest {
    //("arguments[0].click();", element)
    //("arguments[0].setAttribute['value', '" + longstring +"')", element);
    @Test
    public void googleSerchTest() throws InterruptedException {

        SeleniumHelper helper = new SeleniumHelper(driver);

        // Test najachania na element Hover

        driver.get("https://www.w3schools.com/");

        WebElement tutorialsW3School = driver.findElement(By.id("navbtn_tutorials"));
        Actions actionHoover = new Actions(driver);

        actionHoover.moveToElement(tutorialsW3School).build().perform();



        //Test Wyszukiwarki Googla

        driver.get("http://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));


        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("alert('Tekst z executora')");


        //Symulacja klikniecia prawym klawiszem myszy
        Actions action = new Actions(driver);
        //na wolnym polu okna przeglądarki
        action.contextClick().build().perform();
        //na wskazanym elemencie na stronie przeglądarki
//        action.contextClick(searchInput).build().perform();

        //Akcja wpisania tekstu w pole input w wyszukiwarce
        executor.executeScript("arguments[0].setAttribute('value', 'Selenium')", searchInput);

        helper.takeScreenShot();


        searchInput.sendKeys(Keys.ENTER);
        WebElement seleniumLink = driver.findElement(By.xpath("//h3[text()='Selenium']"));
//        WebElement seleniumLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3"));
//        WebElement seleniumLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div.r > a > h3"));

        //Akcja klikniecia wywolana przez kod JS
        executor.executeScript("arguments[0].click();", seleniumLink);
        helper.takeScreenShot();

        //Asercje

        Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");

    }


}
