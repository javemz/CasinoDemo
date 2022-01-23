package tasks;

import actions.WaitUntil;
import org.openqa.selenium.WebDriver;
import ui.DepositUI;

public class IsMessagePresent {
    public static boolean onContainer(WebDriver driver, String message){
        return WaitUntil.textElementIsPresent(driver, DepositUI.DEPOSIT_MODAL_CONTENT, message);
    }
}
