package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class P02_PlaceOrder {
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    public P02_PlaceOrder(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToBottom()
    {

        javascriptExecutor.executeScript("scrollBy(0,2500)");
    }

    private final By signin=By.xpath("(//a)[2]");
    private final By Email = By.id("email");
    private final By Password = By.id("pass");
    private final By loginButton = By.id("send2");
    private final By  ClickOnWhatNew = By.xpath("//a[@id=\"ui-id-3\"]");
    private final By SelectProduct = By.xpath("//a[@title=\"Phoebe Zipper Sweatshirt\"]");
    private final By  ClickCompListPage = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[5]/div/a[2]/span");
    private final By ClickAddToCart_1 = By.xpath("//button[span=\"Add to Cart\"]");
    private final By  SelectSize = By.xpath("//div[@id=\"option-label-size-143-item-167\"]");
    private final By  SelectColor = By.xpath("//div[@id=\"option-label-color-93-item-52\"]");
    private final By  ClickAddToCartBtn = By.xpath("//button[@title=\"Add to Cart\"]");
    private final By ClickOnShoppingCart =By.xpath("//a[text()=\"shopping cart\"]") ;

    public P02_PlaceOrder UserClickOnWhatNew() {
        driver.findElement(this.ClickOnWhatNew).click();
        return this;
    }
    public P02_PlaceOrder UserSelectProduct() {
        driver.findElement(this.SelectProduct).click();
        return this;
    }
    public P02_PlaceOrder UserClickCompListOption() {
        driver.findElement(this.ClickCompListPage).click();
        return this;
    }
    public P02_PlaceOrder UserClickOnAddToCart() {
        driver.findElement(this.ClickAddToCart_1).click();
        return this;
    }
    public P02_PlaceOrder UserSelectProductSize() {
        driver.findElement(this.SelectSize).click();
        return this;
    }
    public P02_PlaceOrder UserSelectProductColor() {
        driver.findElement(this.SelectColor).click();
        return this;
    }
    public P02_PlaceOrder UserClickAddToCartButton() {
        driver.findElement(this.ClickAddToCartBtn).click();
        return this;
    }
    public P02_PlaceOrder UserClickOnShoppingCart() {
        driver.findElement(this.ClickOnShoppingCart).click();
        return this;
    }

    public P02_PlaceOrder FillEmail(String email) {
        driver.findElement(this.Email).sendKeys(email);
        return this;
    }
    public P02_PlaceOrder FillPassword(String password) {
        driver.findElement(this.Password).sendKeys(password);
        return this;
    }
    public P02_PlaceOrder ClickSigninTap() {
        driver.findElement(this.signin).click();
        return this;
    }
    public P02_PlaceOrder ClickLoginButton() {
        driver.findElement(this.loginButton).click();
        return this;
    }



}
