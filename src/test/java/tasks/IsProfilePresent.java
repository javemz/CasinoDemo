package tasks;

import actions.WaitUntil;
import org.openqa.selenium.WebDriver;
import ui.UserInfoUI;

public class IsProfilePresent {

    public static boolean userInfo(WebDriver driver, String message){
        return WaitUntil.textElementIsPresent(driver, UserInfoUI.USER_AVATAR_CONTENT, message.toUpperCase());
    }
}
