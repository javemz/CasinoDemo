package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.*;
import ui.HomeUI;


public class LoginTest extends BaseTests {

    @Test(testName = "loginSuccessfully")
    public void loginSuccessfully(){

        SelectMenu.on(driver, HomeUI.SING_BUTTON);
        Login.as(driver,"pruebajavier@test.com", "jav4eT", true);
        Assert.assertTrue(IsProfilePresent.userInfo(driver,"bart"));
        Logout.profile(driver);
        Assert.assertFalse(IsProfilePresent.userInfo(driver,"bart"));
    }

}
