package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    public static boolean elementIsPresent(WebDriver driver, By locator){

        try{
            WebDriverWait wait = new WebDriverWait(driver,3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean textElementIsPresent(WebDriver driver, By locator, String text){

        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator),text));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
