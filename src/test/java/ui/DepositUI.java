package ui;

import org.openqa.selenium.By;

public class DepositUI {

    public static By DEPOSIT_LINK = By.xpath("//li[@class='transactions__item']/a");
    public static By AMOUNT_INPUT = By.id("DepositForm_amount");
    public static By DEPOSIT_CONFIRM_BUTTON = By.id("btn-deposit");
    public static By DEPOSIT_MODAL_CONTENT = By.xpath("//div[@class='modal__content purple']");

}
