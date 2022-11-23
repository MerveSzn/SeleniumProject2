package Utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.LogInPage;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author merve.sozen
 */
public class Utilities {
    WebDriver driver;
    Logger log = Logger.getLogger(Utilities.class.getName());

    public void waitforAjax() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void search(String searchProduct) throws InterruptedException {
        WebElement element=driver.findElement(By.className("vQI670rJ"));
        element.click();
        waitforAjax();
        element.sendKeys(searchProduct);
        element.sendKeys(Keys.ENTER);
        String searchPage=driver.findElement(By.className("dscrptn")).getText();
        Assert.assertEquals(Variables.searchWord, searchPage);
    }
    public void filterBrand(String filterName) throws Exception {
        WebElement element=driver.findElement(By.className("fltr-srch-inpt"));
        WebElement filterItem=driver.findElement(By.className("fltr-item-wrppr"));
        element.click();
        waitforAjax();
        element.sendKeys(filterName);
        element.sendKeys(Keys.ENTER);
        if(filterItem.isDisplayed()){
            filterItem.findElement(By.className("chckbox")).click();
        }else{
            throw new Exception(filterName +" brand does not exist");
        }

    }
    public void filterPrice(int max, int min) {
        WebElement elementmin=driver.findElement(By.className("fltr-srch-prc-rng-input min"));
        elementmin.click();
        elementmin.sendKeys(String.valueOf(min));

        WebElement elementmax=driver.findElement(By.className("fltr-srch-prc-rng-input max"));
        elementmax.click();
        elementmax.sendKeys(String.valueOf(max));

    }
    public void clickSearchbtn() {
        driver.findElement(By.className("fltr-srch-prc-rng-srch")).click();
    }

    public void selectProduct() throws Exception {
        List<WebElement> elements= driver.findElements(By.className("prdct-cntnr-wrppr"));
        elements.get(1).click();
        driver.findElement(By.className("add-to-basket")).click();
        String addedbaskettext= driver.findElement(By.className("product-preview-status-text")).getText();
        if(addedbaskettext.equals("Ürün Sepete Eklendi!")){
            log.info("Product added to basket!");
        }else{
            throw new Exception("Product not added to basket!");
        }
    }

    public void addFavourite(){

        List<WebElement> elements= driver.findElements(By.className("prdct-cntnr-wrppr"));
        elements.get(1).findElement(By.className("fvrt-btn")).click();
        WebElement element=driver.findElement(By.className("i-heart-orange"));
        element.click();
        String openedPage = element.getText();
        Assert.assertEquals("Favorilerim", openedPage);

    }

    public void addFavouriteBasket(){

        List<WebElement> elements= driver.findElements(By.className("favored-product-container"));
        elements.get(0).findElement(By.className("basket-button")).click();

    }

    public void clickTabs(){

        driver.findElement(By.linkText("Kadın")).click();
        driver.findElement(By.linkText("Erkek")).click();
        driver.findElement(By.linkText("Anne & Çocuk")).click();
        driver.findElement(By.linkText("Ev & Mobilya")).click();
        driver.findElement(By.linkText("Süpermarket")).click();
        driver.findElement(By.linkText("Kozmetik")).click();
        driver.findElement(By.linkText("Ayakkabı & Çanta")).click();
        driver.findElement(By.linkText("Saat & Aksesuar")).click();
        driver.findElement(By.linkText("Elektronik")).click();
        driver.findElement(By.linkText("Spor&Outdoor")).click();


    }


}