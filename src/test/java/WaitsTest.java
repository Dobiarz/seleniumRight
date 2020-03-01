import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseSeleniumTest;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitsTest extends BaseSeleniumTest {

    @Test
    public void waitTest() {

        //Oczekiwanie na element Thread.sleep()

       /*
       driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\Waits.html");

        WebElement button = driver.findElement(By.tagName("button"));

        String setTimeout = button.getAttribute("onclick").replaceAll("\\D+","");

        System.out.println(setTimeout);
        button.click();


        Thread.sleep(1000 + Integer.parseInt(setTimeout));
        WebElement paragraph = driver.findElement(By.tagName("p"));

        Assert.assertEquals("Dopiero się pojawiłem!", paragraph.getText());
        */

        //Oczekiwanie na pojawienie sie elementów, implicitlyWait dopina się do każdego szukanego elementu
        // i czeka na niego zadany czas
        /*driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\Waits2.html");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement paragraph = driver.findElement(By.tagName("p"));
        Assert.assertEquals("Dopiero się pojawiłem!", paragraph.getText());
        */


        //Oczekiwanie na element -WebDriver Wait
        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\Waits2.html");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        //Program nie pójdzie dalej dopoki nie przejdzie matody waitForElements()
//        waitForWebElement(By.tagName("p"));
//        waitForWebElementFluentWait(By.tagName("p"));
        waitForWebElementOwnExpectedConditionLambda(By.tagName("p"));

        WebElement paragraph = driver.findElement(By.tagName("p"));
        Assert.assertEquals("Dopiero się pojawiłem!", paragraph.getText());


    }

    public void waitForWebElement(By locator) {
        // 10L w konstruktorze oznacza czas czekania na spelnienie warunku ExpectedCondotion
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
        //Ustalenie co jaki czas srtona jest sprawdzana , czy spełnione są już warunki z ExpectedCondition
        ((WebDriverWait) wait).pollingEvery(Duration.ofMillis(500));

        //Selenium działa w tle, a dokłądnie  metoda visibilityofElementLocated czeka na zadany locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForWebElementFluentWait(By locator) {
        //W FluentWait nie ignoruje NoSuchException, mamy większy wpływ n
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        //Ustalenie co jaki czas strona jest sprawdzana , czy spełnione są już warunki z ExpectedCondition
        wait.pollingEvery(Duration.ofMillis(500));
        //Czas działania wait-a
        wait.withTimeout(Duration.ofSeconds(10L));
        //Dodanie ignorowanie wyjątku, podczas czekania na element wiemy że program może rzucac wyjątkami
        //WebDriverWait ignorowanie wyjątku NoSuchElementException ustawia już w konstruktorze
        wait.ignoring(NoSuchElementException.class);
        //Selenium działa w tle, a dokłądnie  metoda visibilityofElementLocated czeka na zadany locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForWebElementOwnExpectedCondition(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);

        wait.until(new Function<WebDriver, Boolean>() {
            //implementacja metody apply, Na konsoli co jakis czas pojawia się "Sprawdzam", bo program wchodzi do ifa
            // dostaje wyjątek NosSuchElementExpception (ignorowany) po czym ponownie wchodzi do IFa itd
            @Override
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Sprawdzam");
                if (driver.findElement(locator).isDisplayed()) {
                    System.out.println("Element jest wyswietlany");
                    return true;
                } else {
                    System.out.println("Element nie jest wyswietlany");
                    return false;
                }
            }
        });
    }

    public void waitForWebElementOwnExpectedConditionList(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);

        wait.until(new Function<WebDriver, Boolean>() {
            //implementacja metody apply, Na konsoli co jakis czas pojawia się "Element nie jest wyswietlany"
            // , bo program wchodzi do If-else ponieważ nie jest spełniony warunek list.size>0
            // po czym ponownie wchodzi do IFa itd
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> list = driver.findElements(By.tagName("p"));
                if (list.size() > 0) {
                    System.out.println("Element jest wyswietlany");
                    return true;
                } else {
                    System.out.println("Element nie jest wyswietlany");
                    return false;
                }
            }
        });
    }

    public void waitForWebElementOwnExpectedConditionLambda(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
//Interfejs funkcyjny Function ma tylko  metodę apply do zaimplementowania, dlatego można użyć wyrażenia lambda,
// Java domysli się, że chodzi o metodę apply, przekazujemy drivera jako driver1
        wait.until(driver1 -> {
            System.out.println("Sprawdzam");
            if (driver1.findElement(locator).isDisplayed()) {
                System.out.println("Element jest wyswietlany");
                return true;
            } else {
                System.out.println("Element nie jest wyswietlany");
                return false;
            }

        });
    }
}