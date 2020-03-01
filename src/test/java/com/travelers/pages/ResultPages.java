package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPages {

    private SeleniumHelper helper;

    private WebDriver driver;

    public ResultPages(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    WebElement resultTable;

    public List<String> getHotelNames() {
        List<String> hotelNames = new ArrayList<>();
        // kropka przed //h4//boznacza wyszukiwanie tylko w resultTable, brak towyszukiwanie na calej stronie
        helper.waitForListOfWebElements(resultTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> hotelNameWebElements = resultTable.findElements(By.xpath("//h4//b"));
        for (WebElement hotelNameWebElement : hotelNameWebElements) {
            hotelNames.add(hotelNameWebElement.getText());
            System.out.println(hotelNameWebElement.getText());
        }
        return hotelNames;
    }

    public List<String> getHotelPrices() {
        List<WebElement> hotelPricesWebElements = resultTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        List<String> hotelPrices = hotelPricesWebElements.stream().map(element -> element.getText()).collect(Collectors.toList());
        return hotelPrices;

    }
}
