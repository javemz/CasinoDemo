package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.FillDataRegistrationForm;
import tasks.IsMessageRegistrationSuccessfully;
import utils.DataUtil;

import java.io.IOException;
import java.util.HashMap;


public class RegistrationTest extends BaseTests {

    @Test(testName = "registrationSuccessfully", dataProviderClass = DataUtil.class, dataProvider = "dataRegistration")
    public void registrationSuccessfully(HashMap<String, String> hashMap) throws IOException, InterruptedException {

        FillDataRegistrationForm.withData(driver,hashMap);
        Assert.assertTrue(IsMessageRegistrationSuccessfully.onContainer(driver, "Registration successfully finished!"));
    }

}
