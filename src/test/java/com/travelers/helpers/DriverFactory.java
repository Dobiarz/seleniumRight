package com.travelers.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSouchDriverException {
        // if sprawdza czy istnieje juz zainicjonowany driver,
        if (driverInstance == null) {
            //metoda obsluguje uzycie dowolnej przegladarki, czyli dowolnego drivera
            getSpecificDriver(driverType);
            System.out.println("Zmienna zostania zainicjonowana");
//            // alternatywany sposób inicjalizacji drivera, zastapiony przez uzycie metody getSpecyficDriver
//            {
//                File driverExe = new File("src/main/resources/executables/divers/chromedriver");
//                ChromeDriverService driverService = new ChromeDriverService.Builder()
//                        .usingDriverExecutable(driverExe)
//                        .usingAnyFreePort().build();
//                driverInstance = new ChromeDriver(driverService);
//            }

            // inicjalizacja drivera  zastapiony przez uzycie metody getSpecyficDriver
//            {
//            String drirverPath = "/home/tomasz/Desktop/KursSelenium/seleniumRight/src/main/resources/executables/divers/chromedriver";
//            System.setProperty("webdriver.chrome.driver", drirverPath);
//
//            driverInstance = new ChromeDriver();
//            }
            driverInstance.manage().window().maximize();
        }

        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws NoSouchDriverException {
        switch (driverType){
            case IE:
                /* NIE DZIALA, brak drivera IEDriverServer */
                File ieExe = new File("src/main/resources/executables/divers/IEDriverServer");
                InternetExplorerDriverService ieService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(ieExe)
                        .usingAnyFreePort().build();
                driverInstance = new InternetExplorerDriver(ieService);
                break;
            case CHROME:
                File chromeExe = new File("src/main/resources/executables/divers/chromedriver");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
                break;
            case FIREFOX:

                File firefoxExe = new File("src/main/resources/executables/divers/geckodriver");
                GeckoDriverService geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(geckoDriverService);

                break;

                default:
                    System.out.println("Brak drivera danego typu");
                    throw new NoSouchDriverException();
        }
    }

    public static void resetDriver() {
        driverInstance = null;
    }
}
