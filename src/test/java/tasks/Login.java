package tasks;

import actions.Click;
import actions.Enter;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;
import ui.LoginUI;

public class Login {

    public static void as(WebDriver driver, String user, String password, boolean rememberMeCheck){
        SelectMenu.on(driver, HomeUI.SING_BUTTON);
        Enter.text(driver, LoginUI.USERNAME_INPUT, user);
        Enter.text(driver, LoginUI.PASSWORD_INPUT, password);
        if(rememberMeCheck)
            Click.on(driver, LoginUI.REMEMBER_ME_CHECK);
        Click.on(driver, LoginUI.SIGN_IN_BUTTON);
    }





}
