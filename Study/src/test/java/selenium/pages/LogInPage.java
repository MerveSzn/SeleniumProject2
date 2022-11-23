package selenium.pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

/**
 * @author merve.sozen
 */
public class LogInPage extends Utilities {

    WebDriver driver;
    Logger log = Logger.getLogger(LogInPage.class.getName());

    public LogInPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterLogin() throws InterruptedException {
            driver.findElement(By.className("account-nav-item")).click();
            new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
            waitforAjax();

        }

        public void clickLogin() throws InterruptedException {
            driver.findElement(By.className("q-primary ")).click();
            waitforAjax();
        }

        public void verifyAccount() throws Exception {
            driver.findElement(By.className("account-nav-item")).click();
            WebElement element = driver.findElement(By.className("i-my-orders"));
            if(element.isDisplayed()){
                log.info("user account is opened");
            } else {
                throw new Exception("Test Failed");
            }
        }
    }



