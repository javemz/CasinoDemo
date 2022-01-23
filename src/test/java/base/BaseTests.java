package base;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Report;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * user javiereduardomzpa@gmail.com
 *
 * **/
public class BaseTests {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        Report.createReport();
        Report.createTest("Casino Demo");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://demo.casino/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        Report.closeReport();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult results) throws IOException {

        /*if(ITestResult.FAILURE==results.getStatus())
        {
            var camera  = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            String nameScreenshot = "screenshots/" + System.currentTimeMillis()+ ".png";
            try{
                Files.move(screenshot, new File("resources/reports/" + nameScreenshot),null)
                Report.test.log(Status.FAIL, Report.test.addScreenCaptureFromPath(nameScreenshot) + "Test Failed");
            }catch(IOException e) {
                e.printStackTrace();
            }

        }
        else{
            Report.test.log(Status.INFO,"TestCase is pass");
        }*/


    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        return options;
    }
}
