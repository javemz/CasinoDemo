package tasks;

import com.aventstack.extentreports.Status;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.Report;

import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;

public class ResolveCaptcha {


    public static void saveCaptchaImage(WebDriver driver, By captchaImg) {
        Screenshot screenshot;
        screenshot = new AShot().shootingStrategy(ShootingStrategies.
                viewportPasting(1000)).
                takeScreenshot(driver,driver.findElement(captchaImg));
        try {
            ImageIO.write(screenshot.getImage(), "jpg", new File("src/main/resources/captchaImage/image.jpg"));
        }catch (Exception e)
        {

        }

    }


    /**
     * there is a library with all this in reduce way but don't works well
     * so for do manually firs we send a post request with the image captcha file and a key generated on 2captcha.com
     * this service respond an id.
    */
    public static String getCaptchaText(WebDriver driver, By captchaImg) throws IOException, InterruptedException {

        saveCaptchaImage(driver, captchaImg);
        String responsePost = null;
        String key = "07247e2980651130bca5201a70d05289";
        String captchaValue = null;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("https://2captcha.com/in.php");

            FileBody bin = new FileBody(new File("src/main/resources/captchaImage/image.jpg"));
            StringBody comment = new StringBody(key, ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("file", bin)
                    .addPart("key", comment)
                    .build();


            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    responsePost = EntityUtils.toString(resEntity, "UTF-8").replace("OK|","");
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }

            Thread.sleep(3000);
            captchaValue = sendGet(key,responsePost);

            //if captcha is not ready, try one more time
            if(captchaValue.contains("CAPCHA_NOT_READY")){
                Thread.sleep(2000);
                captchaValue = sendGet(key,responsePost);
            }
        } finally {
            httpclient.close();
        }
        captchaValue = captchaValue.replace("OK|","");
        Report.test.log(Status.INFO,"Resolving Captcha: "+captchaValue);
        return captchaValue;
    }

    /**
     * After receiving the code of the response post we need to wait 3 seconds for send a get
     * in this service we send key and an id post
     * the service responds the captcha in a text
     */

    public static String sendGet(String key, String responsePost) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseGet = null;
        try{
            HttpGet httpGetRequest  = new HttpGet("https://2captcha.com/res.php?key="+key+"&action=get&id="+responsePost);
            CloseableHttpResponse response = httpclient.execute(httpGetRequest);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    responseGet = EntityUtils.toString(resEntity, "UTF-8");
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        }catch (Exception e){

        }finally {
            httpclient.close();
        }

        return responseGet;
    }

}
