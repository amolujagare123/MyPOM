package regression;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by user on 2/12/2017.
 */
public class LoginTest {
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    @Test
    public void logintest()
    {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");

        driver.get(rb.getString("url"));


        Login login = new Login(driver);                // create the  object for login class
        login.setUsername("amolujagare@gmail.com");    // from login class we need to pass string for set username
        login.setPassword("admin123");
        login.clickLogin();

        String actual = "";
        String expected = "Quick Actio";

        actual = driver.findElement(By.xpath(".//*[@id='panel-quick-actions']/div[1]/b")).getText();

        Assert.assertEquals(actual, expected);
    }
}
