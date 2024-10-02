package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_PlaceOrder;
import pages.P03_PaymentInfo;
import utilities.utlity;

import static testcases.TC01_UserAccountCreation.EMAIL;
import static testcases.TC01_UserAccountCreation.PASSWORD;

public class TC02_UserCanCreateOrder extends TestBase{
    private static String StreetName;
    private static String City;
    private static String ZIPCode;
    private static String PhoneNum;

    /*public void loginWithValidData() {
        new P02_PlaceOrder(driver).ClickSigninTap()
                .FillEmail(EMAIL)
                .FillPassword(PASSWORD)
                .ClickLoginButton();
    }*/
    @Test
    public void userClickOnWhatSNews() {

        new P02_PlaceOrder(driver).UserClickOnWhatNew();
    }
    @Test
    public void userChooseProduct() {

        new P02_PlaceOrder(driver).UserSelectProduct();
    }
    @Test
    public void userClickAtAddToCompareList() {
        new P02_PlaceOrder(driver).UserClickCompListOption();
        utlity.captureScreenshot(driver, "ProductAddToCompareList");
    }

@Test
public void userFillAllShippingAddressAndPaymentInformation() {
    // StreetName | City  | ZIP  | PhoneNum
    StreetName= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","StreetName");
    City= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","City");
    ZIPCode= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","ZIP");
    PhoneNum= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","PhoneNum");

    new P03_PaymentInfo(driver).UserEnterStreetAddress(StreetName).UserEnterCity(City).
            UserEnterState().UserEnterZIP(ZIPCode).UserEnterCountry()
            .UserEnterphoneNumber(PhoneNum).UserClickOnNextButton().UserClickOnPlaceOrderButton();
}
@Test
public void verifyOrderCreatedSuccessfully() {
    Assert.assertTrue(new P03_PaymentInfo(driver).PlaceOrderSuccessMessage());
    utlity.captureScreenshot(driver, "PlaceOrderSuccess");
}

}
