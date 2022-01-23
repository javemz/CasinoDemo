package tasks;

import actions.WaitUntil;
import org.openqa.selenium.WebDriver;
import ui.RegistrationSuccessfullyUI;

public class IsMessageRegistrationSuccessfully {
    public static boolean onContainer(WebDriver driver, String message){
        return WaitUntil.textElementIsPresent(driver, RegistrationSuccessfullyUI.NOTIFICATION_CONTENT, message);
    }
}
