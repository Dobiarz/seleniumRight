import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.BaseSeleniumTest;

import java.util.List;

public class AnnotationsTest extends BaseSeleniumTest {

    @FindBys({
            //kolejnośc kryteriów ma znaczenie, pierwszy zawęża listę elementów ,
            // kolejny wyszukiwany jest juz w tej zawęzonej list
            @FindBy(tagName = "table"),
            @FindBy(className = "tableHeader")
    })
    private List<WebElement> elements;


    @FindBy(xpath = "//input")
    private List<WebElement> inputs;

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;

    @FindAll({
            @FindBy(xpath = "//button"),
            @FindBy(xpath = "//input")
    })
    private List<WebElement> buttonsAndInputs;


    @Test
    public void googleSearchTestWithFindByPageFactory() {

        SeleniumHelper helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
        driver.get("file:\\home\\tomasz\\Desktop\\KursSelenium\\PlikiPotrzebneDoKursuSelenium\\Test.html");
        System.out.println("Ilość elementóœ " + elements.size());
        System.out.println(inputs.size());
        System.out.println(buttons.size());
        System.out.println(buttonsAndInputs.size());


    }
}
