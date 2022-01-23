package actions;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Report;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class SetDatePickers {

    public static void on(WebDriver driver, By dataPickerContenedor, String text){
        String [] date = text.split("-");
        String day = date[2];
        String month = Month.of(Integer.parseInt(date[1])).toString();
        String year = date[0];

        if(Integer.parseInt(year)<2005){
            WebElement element = driver.findElement(dataPickerContenedor);
            WebElement tittle = element.findElement(By.xpath(".//div[@class='datepicker--nav-title']"));
            List<WebElement> prev = element.findElements(By.xpath(".//div[@class='datepicker--nav-action']"));

            Click.onWebElement(tittle);
            tittle = element.findElement(By.xpath(".//div[@class='datepicker--nav-title']"));// se llama de nuevo porque pierde la referencia
            Click.onWebElement(tittle);

            boolean yearSelected = true;
            int att = 0;

            while(yearSelected){

                List<WebElement> element_list = element.findElements(By.xpath(".//div[@class='datepicker--cells datepicker--cells-years']/div"))
                        .stream()
                        .filter(elementTarget -> elementTarget.getText().contentEquals(year))
                        .collect(Collectors.toList());

                if(element_list.size()>0){
                    element_list.get(0).click();
                    yearSelected = false;
                }
                else if(att==4){
                    yearSelected = false;
                }
                else{
                    prev.get(0).click();
                }

                att++;

            }

            List<WebElement> element_months = element.findElements(By.xpath(".//div[@class='datepicker--cells datepicker--cells-months']/div"))
                    .stream()
                    .filter(elementTarget -> elementTarget.getText().toUpperCase().contentEquals(month))
                    .collect(Collectors.toList());

            if(element_months.size()>0){
                element_months.get(0).click();
            }

            List<WebElement> element_days = element.findElements(By.xpath(".//div[@class='datepicker--cells datepicker--cells-days']/div"))
                    .stream()
                    .filter(elementTarget -> elementTarget.getText().toUpperCase().contentEquals(day))
                    .collect(Collectors.toList());

            if(element_days.size()>0){
                element_days.get(0).click();
            }
        }
        else {

            Report.test.log(Status.FAIL,"The year of birthday date must be less than 2005");
        }

    }

}
