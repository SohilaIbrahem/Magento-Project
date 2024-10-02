package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_CreateNewAccount;
import retry.Retry;
import utilities.utlity;

public class TC01_UserAccountCreation extends TestBase{

    private static String FIRST_NAME;
    private static String LAST_NAME;
    public static String EMAIL;
    public static String PASSWORD;

    @Test(retryAnalyzer = Retry.class)
    public void UserCanCreateAnOrder(){
        FIRST_NAME= utlity.getExcelData(1,0,"Sheet1");
        LAST_NAME= utlity.getExcelData(1,1,"Sheet1");
        EMAIL= utlity.getExcelData(1,2,"Sheet1");
        PASSWORD= utlity.getExcelData(1,3,"Sheet1");


        new P01_CreateNewAccount(driver).UserClickOnCreateNewAccount().UserEnterFirstName(FIRST_NAME)
           .UserEnterLastName(LAST_NAME)
           .UserEnterEmail(EMAIL)
           .UserEnterPassword(PASSWORD)
           .UserEnterConfirmationPassword(PASSWORD)
           .UserClickOnCreateAnAccountButton();

        utlity.captureScreenshot(driver, "Create Account Screenshot");
        Assert.assertTrue(new P01_CreateNewAccount(driver).RegisterAssertion());
    }

}
