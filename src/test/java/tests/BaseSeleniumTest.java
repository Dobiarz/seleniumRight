package tests;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSouchDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    // @BeforeTest powodowal blad poniewaz drivr/przegladarka nie restartwala sie po pierwszy wykonaniu searchHotelTest()
// i pola city, checin date itp byly caly czas wypelnione co uniemozliwialo wypelnienie ich
// przy drugim uzyciu metody searchHotelTest
//    @BeforeTest
    //setup bedzie odpalana po kazdorazowym wykonaniu metody searchHotelTest(),
// jest wykonywana dwukrotnie ze wzgledu na uzycie dataprovidera
    @BeforeMethod
    public void setup() throws NoSouchDriverException {

        System.out.println("Before Test");

        String drirverPath = "/home/tomasz/Desktop/KursSelenium/seleniumRight/src/main/resources/executables/divers/chromedriver";
        System.setProperty("webdriver.chrome.driver", drirverPath);

        driver = DriverFactory.getDriver(DriverType.CHROME);

    }

//    @AfterTest
    @AfterMethod
    public void tearDown() {

        System.out.println("After Test");
        driver.quit();
        //driverInstance musi po zamknieciu przegladarki byc ustawony na null,
        // aby getDriver w Driver factor poprawnie zadzialoalo
        // zamkniecie drivwrw/przegladrki nie ustawia tego nulla
        DriverFactory.resetDriver();

    }
}
