package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class SelectOption {

    public static void byVisibleText(WebDriver driver, By locator, String text){
        WebElement element = driver.findElement(locator).findElement(By.xpath("./ancestor::div[@class='form__input form__input--select select    ']"));
        element.click();

        List<WebElement> element_list = element.findElements(By.xpath(".//ul/li"))
                                        .stream()
                                        .filter(elementTarget -> elementTarget.getText().contentEquals(text))
                                        .collect(Collectors.toList());

        element_list.get(0).click();
    }

}
