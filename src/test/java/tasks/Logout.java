package tasks;

import actions.Click;
import org.openqa.selenium.WebDriver;
import ui.LoginUI;

public class Logout {
    public static void profile(WebDriver driver){
        Click.on(driver, LoginUI.LOGOUT_LINK);
    }
}
