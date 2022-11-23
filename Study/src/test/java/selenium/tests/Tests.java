package selenium.tests;

import Utilities.Utilities;
import Utilities.Variables;

import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.pages.LogInPage;
import selenium.pages.SignUpPage;

/**
 * @author merve.sozen
 */
public class Tests extends Utilities {

    //Scenario 1:
    @Test
    public void loginTest() throws Exception {
        String Chrome_Driver_Path = "C:\\ChromeDriver\\chromedriver.exe";
        String expectedTitle = "trendyol";
        String url = Variables.BASE_URL;
        Logger log = Logger.getLogger(Tests.class.getName());

        System.setProperty("webdriver.chrome.driver", Chrome_Driver_Path);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
        String actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            log.info("Right Website is opened");
        } else {
            throw new Exception("Test Failed");
        }
        //Creating object of login page and sigup page
        LogInPage home = new LogInPage(driver);
        home.enterLogin();
        SignUpPage signUp = new SignUpPage(driver);
        log.info("UserName and Password is entered");
        signUp.enterUserName(Variables.userName);
        signUp.enterPassword(Variables.password);
        home.clickLogin();
        home.verifyAccount();
        log.info("Trendyol is logined.");

    }

    @Test
    //Scenario 2-1:
    public void searchAndSelectComputer() throws Exception {
        search(Variables.searchWord);
        filterBrand(Variables.brand);
        filterPrice(Variables.minPriceValue, Variables.maxPriceValue);
        clickSearchbtn();
        selectProduct();
    }

    @Test
    //Scenario 2-2:
    public void selectFavoriteProduct() throws Exception {
        search(Variables.searchWord2);
        addFavourite();
        addFavouriteBasket();
    }

    @Test
    //Scenario 3-1:
    public void controlTabs() {
        clickTabs();
    }

}
