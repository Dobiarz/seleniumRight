import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.BaseSeleniumTest;

public class DragAndDropTest extends BaseSeleniumTest {

    @Test
    public void dragAndDropTest() {

//        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.get("https://demoqa.com/droppable/");
        WebElement elToDrag = driver.findElement(By.id("draggable"));
        WebElement dropZone = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        action.dragAndDrop(elToDrag,dropZone).build().perform();


    }
}
