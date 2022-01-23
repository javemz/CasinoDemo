package tasks;

import actions.Click;
import actions.Enter;
import actions.SelectOption;
import actions.SetDatePickers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.HomeUI;
import ui.RegistrationFormUI;

import java.io.IOException;
import java.util.HashMap;

import static ui.RegistrationFormUI.*;

public class FillDataRegistrationForm {

    /**
     *
     * @param driver
     * @param hashMap with all the data to use
     * @throws IOException because we need used for get captcha text
     * @throws InterruptedException  because we need used for get captcha text
     * for the data unique we used System.currentTimeMillis();
     */
    public static void withData(WebDriver driver, HashMap<String, String> hashMap) throws IOException, InterruptedException {
        SelectMenu.on(driver, HomeUI.REGISTRATION_BUTTON);
        long valueUnique = System.currentTimeMillis();
        String methodLogin = hashMap.get("methodRegistration");
        String valueMethod = valueUnique + hashMap.get("valueMethod");

        if(methodLogin.equals("email")){
            Click.on(driver, EMAIL_SELECT);
            Enter.text(driver, EMAIL_INPUT,valueMethod);
        }
        else if(methodLogin.equals("phoneNumber")){
            Click.on(driver, PHONE_NUMBER_SELECT);
            Enter.text(driver, PHONE_NUMBER_INPUT,valueMethod);
        }

        Click.on(driver,By.xpath(RegistrationFormUI.CURRENCY_RADIO.replace("CURRENCYTOREPLACE",hashMap.get("currency"))));
        Click.on(driver, TERM_CONDITIONS_CHECK);
        Enter.text(driver, PASSWORD_INPUT,hashMap.get("password"));
        Enter.text(driver, CONFIRM_PASSWORD,hashMap.get("password"));
        String captchaText = ResolveCaptcha.getCaptchaText(driver, CAPTCHA_IMG);
        Enter.text(driver, CAPTCHA_INPUT,captchaText);
        Enter.text(driver, USERNAME_INPUT, valueUnique + hashMap.get("username"));
        Enter.text(driver, NAME_INPUT, hashMap.get("name"));
        Enter.text(driver, SURNAME_INPUT, hashMap.get("surname"));
        Enter.text(driver, MIDDLENAME_INPUT, hashMap.get("middleName"));

        if(hashMap.get("registrationBonus").equals("true"))
            Click.on(driver, BONUS_ZERO_RADIO);
        else if(!hashMap.get("registrationCodeBonus").isEmpty()){
            Click.on(driver, PROMO_CODE_RADIO);
            Enter.text(driver, PROMO_CODE_INPUT, hashMap.get("registrationCodeBonus"));
        }
        else
            Click.on(driver, BONUS_ZERO_RADIO);

        if(hashMap.get("receiveNewsAndPromotions").equals("false"))
            Click.on(driver, RECEIVE_NEWS_PROMOTIONS_CHECK);

        Click.on(driver, BIRTHDAY_INPUT);
        SetDatePickers.on(driver, DATEPICKERS_CONTAINER, hashMap.get("birthday"));
        Enter.text(driver, NICKNAME_INPUT, valueUnique + hashMap.get("nickName"));
        Enter.text(driver, ADDRESS_INPUT, hashMap.get("address"));
        SelectOption.byVisibleText(driver, COUNTRY_SELECT_INPUT, hashMap.get("country"));
        Enter.text(driver, CITY_INPUT, hashMap.get("city"));
        Enter.text(driver, POSTAL_CODE_INPUT, hashMap.get("postalCode"));
        SelectOption.byVisibleText(driver, GENDER_SELECT,hashMap.get("gender"));
        SelectOption.byVisibleText(driver, SECRET_QUESTION_SELECT, hashMap.get("secretQuestion"));
        Enter.text(driver, ANSWER_INPUT, hashMap.get("answer"));
        Click.on(driver,REGISTRATION_BUTTON);
    }


}
