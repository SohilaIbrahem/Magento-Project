package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.utlity;

public class P03_PaymentInfo {
    private WebDriver driver;
    Select select;
    private JavascriptExecutor javascriptExecutor;

    public P03_PaymentInfo(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToBottom()
    {

        javascriptExecutor.executeScript("scrollBy(0,3500)");
    }

    private final By CheckOutButton = By.xpath("(//button[@title=\"Proceed to Checkout\"])[2]");
    private final By StreetAddress =  By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input");
    private final By City = By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input");
    //private final By State  = By.id("H6U27XD");
    private final By State  = By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select");
    private final By ZIP   = By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[7]/div/input");
    private final By Country  = By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select");
    private final By phoneNumber  = By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input");
    private final By RadioButton =By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button/span");
    private final By NextBtn = By.cssSelector((".button"));
    private final By PlaceOrderBtn =By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button/span");
    private final By CofMsg = By.xpath("//span[text()=\"Thank you for your purchase!\"]");


    public P03_PaymentInfo UserClickOnProccedToCheckOutButton() {
        driver.findElement(this.CheckOutButton).click();
        return this;
    }
    public P03_PaymentInfo UserEnterStreetAddress(String address) {
        driver.findElement(this.StreetAddress).sendKeys(address);
        return this;
    }
    public P03_PaymentInfo UserEnterCity(String city) {
        driver.findElement(this.City).sendKeys(city);
        return this;
    }
    public P03_PaymentInfo UserEnterState() {  //DropDoen
        select = new Select(driver.findElement(this.State));
        select.selectByIndex(utlity.generateRandomNumber(1, 20));
        return this;
    }
    public P03_PaymentInfo UserEnterZIP(String zip) {
        driver.findElement(this.ZIP).sendKeys(zip);
        return this;
    }
    public P03_PaymentInfo UserEnterCountry() {
        select = new Select(driver.findElement(this.Country));
        select.selectByIndex(utlity.generateRandomNumber(1, 6));
        return this;
    }
    public P03_PaymentInfo UserEnterphoneNumber(String phoneNum) {
        driver.findElement(this.phoneNumber).sendKeys(phoneNum);
        return this;
    }

    public P03_PaymentInfo UserCheckShippingMethod()
    {
            driver.findElement(this.RadioButton).click();
       return this;
    }
    public P03_PaymentInfo UserClickOnNextButton() {
        driver.findElement(this.NextBtn).click();
        return this;
    }
    public P03_PaymentInfo UserClickOnPlaceOrderButton() {
        driver.findElement(this.PlaceOrderBtn).click();
        return this;
    }

    public Boolean PlaceOrderSuccessMessage()
    {
        return driver.findElement(this.CofMsg).getText().equals("Thank you for your purchase!");
    }
}
