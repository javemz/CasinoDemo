package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.*;
import ui.DepositUI;


public class BuyCreditsTest extends BaseTests {

    @Test(testName = "addCredits")
    public void addCredits(){
        Login.as(driver,"pruebajavier@test.com", "jav4eT", true);
        Assert.assertTrue(IsProfilePresent.userInfo(driver,"bart"));
        Deposit.Credits(driver, "2000");
        Assert.assertTrue(IsMessagePresent.onContainer(driver, "SUCCESS"));
        //credits are not added to the user's profile
    }

}
