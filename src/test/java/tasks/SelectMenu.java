package tasks;

import actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectMenu {

    public static void on(WebDriver driver, By menu){
        Click.on(driver, menu);
    }

}
