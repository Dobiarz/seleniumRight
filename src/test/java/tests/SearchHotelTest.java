package tests;

import com.travelers.helpers.TestListner;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPages;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


@Listeners(TestListner.class)
public class SearchHotelTest extends BaseSeleniumTest {


    @Test
    public void searchHotelTest() throws IOException {
        //Ponizsza linijka driver.mange zapewnia zaladowanie sie wszystkich elementow strony
        // obecnie jest niekonieczna ze wzgledu na metody waitFor...  w klasie Selenium helper
//        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver)
        .setCityHotel("Dubai")
        .setDataRange("09/11/2019", "13/11/2019")
        .openTravellersModel()
        .addAdult()
        .addChild()
        .addChild();
        homePage.performSearch();

        ResultPages resultPages = new ResultPages(driver);

        List<String> hotelNames = resultPages.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        List<String> hotelPrices = resultPages.getHotelPrices();
        Assert.assertEquals("$22", hotelPrices.get(0));
        Assert.assertEquals("$50", hotelPrices.get(1));


    }
}
