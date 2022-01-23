package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Click {

    public static void on(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public static void onWebElement(WebElement webElement){
        webElement.click();
    }

}
