package selenium.pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author merve.sozen
 */
public class SignUpPage extends Utilities {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName) throws InterruptedException {

        WebElement element=driver.findElement(By.name("login"));
        element.click();
        waitforAjax();
        element.sendKeys(userName);

    }

    public void enterPassword(String password) throws InterruptedException {
        WebElement element= driver.findElement(By.name("login-password"));
        element.click();
        waitforAjax();
        element.sendKeys(password);
    }

}
