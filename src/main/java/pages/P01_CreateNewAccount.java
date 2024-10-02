package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_CreateNewAccount {
    private WebDriver driver;

    public P01_CreateNewAccount(WebDriver driver) {
        this.driver = driver;
    }

    private final By CreateNewAccount = By.xpath("//a[contains(text(),'Create an Account')]");
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By Email = By.id("email_address");
    private final By Password = By.id("password");
    private final By ConfPassword = By.id("password-confirmation");
    private final By CreateAccBtn = By.xpath("//button[@title=\"Create an Account\"]");
    private final By AssertRegister=By.xpath("//div[text()=\"Thank you for registering with Main Website Store.\"]");


    public P01_CreateNewAccount UserClickOnCreateNewAccount() {
        driver.findElement(this.CreateNewAccount).click();
        return this;
    }
    public P01_CreateNewAccount UserEnterFirstName(String FName) {
        driver.findElement(this.firstName).sendKeys(FName);
        return this;
    }
    public P01_CreateNewAccount UserEnterLastName(String LName) {
        driver.findElement(this.lastName).sendKeys(LName);
        return this;
    }
    public P01_CreateNewAccount UserEnterEmail(String email) {
        driver.findElement(this.Email).sendKeys(email);
        return this;
    }
    public P01_CreateNewAccount UserEnterPassword(String pass) {
        driver.findElement(this.Password).sendKeys(pass);
        return this;
    }
    public P01_CreateNewAccount UserEnterConfirmationPassword(String confPass) {
        driver.findElement(this.ConfPassword).sendKeys(confPass);
        return this;
    }
    public P01_CreateNewAccount UserClickOnCreateAnAccountButton() {
        driver.findElement(this.CreateAccBtn).click();
        return this;
    }
    public Boolean  RegisterAssertion()
    {
        return driver.findElement(this.AssertRegister).getText().equals("Thank you for registering with Main Website Store.");
    }


}
