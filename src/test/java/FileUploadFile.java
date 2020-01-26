import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadFile extends BaseSeleniumTest {

    @Test
    public void uploadFileTest() {
        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\FileUpload.html");

        String path = new File("src/main/resources/test447000000.png").getAbsolutePath();

        driver.findElement(By.id("myFile")).sendKeys(path);


    }
}
