package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    ////*[@id="select2-drop"]/div/input
    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchCityInput;


    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    WebElement searchButton;



    @FindBy(xpath = "//div[@class='select2-result-label']")
    WebElement selectResult;

    private SeleniumHelper helper;

    private WebDriver driver;

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }
// zamina void na HomePage oraz dodanie return this; uozliwia tworzenie tzw lancucha metod w SearchHotelTest
// homePage.setCityHotel.setDataRange itd
    public HomePage setCityHotel(String cityName) {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
//        By locationLabel = By.xpath("//div[@class='select2-result-label']");
//        helper.waitForElementToBeDisplayed(locationLabel);
//        WebElement element = driver.findElement(By.xpath("//div[@class='select2-result-label']"));
        helper.waitForElementToBeDisplayed(selectResult);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;

    }

    public HomePage setDataRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
        return this;
    }

    public HomePage openTravellersModel() {
        helper.waitForElementToBeDisplayed(travellersInput);
        travellersInput.click();
        return this;
    }

    public HomePage addAdult() {
        adultPlusBtn.click();
        return this;
    }

    public HomePage addChild() {
        helper.waitForElementToBeDisplayed(childPlusBtn);
        childPlusBtn.click();
        return this;
    }

    public void performSearch() {
        searchButton.click();

    }


}
