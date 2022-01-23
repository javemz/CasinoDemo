package tasks;

import actions.Click;
import actions.Enter;
import actions.WaitUntil;
import org.openqa.selenium.WebDriver;
import ui.DepositUI;
import ui.HomeUI;

public class Deposit {

    public static void Credits(WebDriver driver, String amount){
        SelectMenu.on(driver, HomeUI.BUY_CREDITS_LINK);
        Click.on(driver, DepositUI.DEPOSIT_LINK);
        WaitUntil.elementIsPresent(driver, DepositUI.AMOUNT_INPUT);
        Enter.text(driver, DepositUI.AMOUNT_INPUT,amount);
        Click.on(driver, DepositUI.DEPOSIT_CONFIRM_BUTTON);
    }
}
