package annonations;

import com.travelers.helpers.TestListner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListner.class)
public class SecondTestDataProvider {
    @Test
    public void firstTest() {
        System.out.println("Test Logowania");
        System.out.println("Username Test1");
        System.out.println("Password Test1");
        Assert.assertEquals(1, 2);
    }

    @Test
    public void secondTest() {
        System.out.println("Test Logowania");
        System.out.println("Username Test2");
        System.out.println("Password Test2");
    }

    // ponizszy test korzysta z dataProvidera,  test zostanie odpalony dla wszystkich parametrów dostarczonych przz dataProvider
    @Test(dataProvider = "getData")
    public void firstTestWithDataProvider(String username, String password) {
        System.out.println("Test Logowania");
        System.out.println("Username " + username);
        System.out.println("Password " + password);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"test1", "test1"}, {"test2", "test2"}};
    }
}
