import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class FirstSeleniumTestFirstPart {

   private  WebDriver driver;

    @Test
    public void googleOpenTest() throws InterruptedException {
        String drirverPath = "/home/tomasz/Desktop/KursSelenium/seleniumRight/src/main/resources/executables/divers/chromedriver";
        System.setProperty("webdriver.chrome.driver", drirverPath);

//        Dimension dimension = new Dimension(1900,800);
        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().setSize(dimension);
//        driver.manage().window().setSize(new Dimension(500,800));
        driver.manage().window().maximize();
//        driver.get("http://www.gogle.com");
        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\Test.html");
//        driver.findElement(By.id("newPage")).click();
//        driver.quit();
//        driver.close();

        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        WebElement clickOnMeButton2 = driver.findElementById("clickOnMe");
        WebElement firstNameInput = driver.findElement(By.name("fname"));
        WebElement W3SchoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        WebElement googleLink = driver.findElement(By.partialLinkText("Weird"));
        WebElement topSecretParagraph = driver.findElementByClassName("topSecret");
        WebElement topSecretParagraph1 = driver.findElement(By.className("topSecret"));
        WebElement firstInput = driver.findElement(By.tagName("input"));
        WebElement firstLink = driver.findElement(By.tagName("a"));
        WebElement cloickOnMeCssButton = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement links = driver.findElement(By.cssSelector("a"));
        WebElement tdFirstChild = driver.findElement(By.cssSelector("td:first-child"));

        WebElement clickOnMeXpathButton = driver.findElement(By.xpath("/html/body/button"));
        WebElement clickOnMeXpathButton1 = driver.findElement(By.xpath("//button"));
        WebElement linksXpath = driver.findElement(By.xpath("//a"));
        WebElement topSecretXpath = driver.findElement(By.xpath("//p[@class='topSecret']"));
        WebElement topSecretXpath2 = driver.findElement(By.xpath("//*[@class='topSecret']"));
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        System.out.println(linkText.getText());

        List<WebElement> links1 = driver.findElements(By.tagName("a"));
        System.out.println("Znaleźono " + links1.size() + " linków");
        List<WebElement> links2 = driver.findElements(By.tagName("addddd"));

        if (links2.size() > 0) {
            System.out.println("Znaleźono " + links2.size() + " linków");

        } else {
            System.out.println("Nie znaleziono żadnych linków");
        }

        String result = "Nie znaleziono żadnych linków";
        System.out.println(links2.size() > 0 ? "Znaleźono " + links2.size() + " linków" : result);

        WebElement clickOnMeXpath = driver.findElement(By.xpath("//*[@id=\"clickOnMe\"]"));

        clickOnMeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        firstNameInput.sendKeys("wpisany tekst");
        firstNameInput.clear();
        firstNameInput.sendKeys("drugi wpisany tekst");

        Select carSelect = new Select(driver.findElement(By.tagName("select")));
//        carSelect.selectByIndex(1);
//        carSelect.selectByVisibleText("Mercedes");
        carSelect.selectByValue("audi");

        WebElement firstNameInputId = driver.findElement(By.id("fname"));
        firstNameInputId.clear();
        firstNameInputId.sendKeys("Tomek");
        System.out.println("wartość input " + firstNameInputId.getAttribute("value"));

        WebElement label = driver.findElement(By.xpath("/html/body/label[2]"));
        System.out.println("Wartość dla label to:" + label.getText());

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
//        Thread.sleep(5000);
        checkbox.click();

        WebElement ratioButton = driver.findElement(By.xpath("//input[@value='male']"));
        ratioButton.click();

        WebElement paragraph = driver.findElement(By.className("topSecret"));
        System.out.println("Moj tekst " + paragraph.getText());
        System.out.println("Moj tekst " + paragraph.getAttribute("value"));
        System.out.println("Moj tekst " + paragraph.getAttribute("textContent"));

        //Sprawdzanie czy obrazek załadował się prawidłowo
        WebElement smileImage = driver.findElement(By.id("smileImage"));
        System.out.println(smileImage.getSize().getHeight());
        System.out.println(smileImage.getSize().getWidth());
        System.out.println(smileImage.getAttribute("naturalHeight"));
        System.out.println(smileImage.getAttribute("naturalWidth"));


        //Sprawdzenie czy element jest edytowalny
        WebElement firstInput1 = driver.findElement(By.name("fname"));

        if (firstInput1.isEnabled()) {

            firstInput1.sendKeys("Tomek");
        } else {
            System.out.println("Element jest zablokowany");
        }
        //Sprawdzanie czy checkbox jest zaznaczony
        WebElement checkbox1 = driver.findElement(By.xpath("/html/body/label[2]/input"));
        System.out.println(checkbox1.isSelected() ? "Jest zaznaczony" : "Nie jest zaznaczony");

        // Sprawdzenie czy element jest widoczny

        WebElement paragraph1 = driver.findElement(By.className("topSecret"));

        if (paragraph1.isDisplayed()) {
            System.out.println("Jest widoczny");
            System.out.println(paragraph1.getText());
        } else {
            System.out.println("Element nie jest widoczny");
            System.out.println(paragraph1.getAttribute("textContent"));
        }
        //Sprawdzenie czy element istnieje na stronie
        checkIfElementExist(By.tagName("a"), driver);
        checkIfElementExist(By.tagName("abcd"), driver);

        checkIfElementExist(driver, By.tagName("a"));
        checkIfElementExist(driver, By.tagName("abcd"));

        // Przełączanie między oknami przeglądarki
        WebElement buttonNewPage = driver.findElement(By.id("newPage"));
        buttonNewPage.click();
        String currentWindowName = driver.getWindowHandle();
//        switchToNewWindow(driver, currentWindowName);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //Powrót do pierwotnego okna
        driver.switchTo().window(currentWindowName);
        driver.findElement(By.name("username")).sendKeys(" Mouse");

        //Test Wyszukiwarki Googla
        driver.get("http://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("selenium" + Keys.ENTER);
//        searchInput.sendKeys(Keys.ESCAPE);
//        searchInput.sendKeys(Keys.ENTER);
//        WebElement searchButton = driver.findElement(By.name("btnK"));

//        searchButton.click();
        WebElement seleniumPage = driver.findElement(By.xpath("//h3[text()='Selenium']"));
        seleniumPage.click();

//        Asercje
        String expectedTitle = "SeleniumHQ Browser Automation";
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertNotEquals("Test1", "Test2");
        Assert.assertTrue(expectedTitle.equals(driver.getTitle()));
        Assert.assertTrue(expectedTitle.equals("Złą nazwa"), "Tytuly nie sa rowne");


    }

    @AfterClass
    public void tearDown() {
        driver.quit();

        System.out.println("po klasie");

    }


    private void switchToNewWindow(ChromeDriver driver, String currentWindowName) {
        System.out.println("wartość dla obecnego okna " + currentWindowName);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Ilosc okien dostępnych " + windows.size());

        for (String window : windows) {
            if (!window.equals(currentWindowName)) driver.switchTo().window(window);
        }

    }

    public boolean checkIfElementExist(By locator, WebDriver driver) {
        if (driver.findElements(locator).size() > 0) {
            System.out.println("Element istnieje1");
            return true;
        }
        System.out.println("Element nie istnieje1");
        return false;
    }

    public void checkIfElementExist(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            System.out.println("Element istnieje2");

        } catch (NoSuchElementException exc) {// Wazne - wyjątek NoSuchelementException musi byc z bibliteki selenium
            System.out.println("Element nie istnieje2");
        }

    }
}
