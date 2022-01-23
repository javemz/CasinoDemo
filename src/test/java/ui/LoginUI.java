package ui;

import org.openqa.selenium.By;

public class LoginUI {

    public static By USERNAME_INPUT = By.id("UserLogin_username");
    public static By PASSWORD_INPUT = By.id("UserLogin_password");
    public static By SIGN_IN_BUTTON = By.xpath("//form[@id='login-form']//button");
    public static By REMEMBER_ME_CHECK = By.xpath("//div[@class='form__input form__input--checkbox checkbox    ']/label");
    public static By LOGOUT_LINK = By.xpath("//a[@class='button button--logout']");

}
