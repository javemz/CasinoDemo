package ui;

import org.openqa.selenium.By;

public class RegistrationFormUI {

    public static By EMAIL_SELECT = By.xpath("//div[@class='registration__tabs tabs__parent']//div[@class='selectric-scroll']/ul/li[1]");
    public static By EMAIL_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_email')]");
    public static By PHONE_NUMBER_SELECT = By.xpath("//div[@class='registration__tabs tabs__parent']//div[@class='selectric-scroll']/ul/li[2]");
    public static By PHONE_NUMBER_CODE_SELECT = By.className("iti__selected-flag");
    public static By PHONE_NUMBER_INPUT = By.cssSelector("//input[contains(@id,'Form_RegistrationForm_phone')]");
    public static String CURRENCY_RADIO = "//label[.='CURRENCYTOREPLACE']";
    public static By TERM_CONDITIONS_CHECK = By.xpath("//input[contains(@id, 'RegistrationForm_terms_and_conditions')]/following-sibling::label");
    public static By PASSWORD_INPUT = By.xpath("//input[contains(@name,'Form_RegistrationForm[password]')]");
    public static By CONFIRM_PASSWORD = By.xpath("//input[contains(@id,'Form_RegistrationForm_password_confirmation')]");
    public static By CAPTCHA_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_captcha')]");
    public static By CAPTCHA_IMG = By.xpath("//input[contains(@id,'Form_RegistrationForm_captcha')]/following-sibling::img");
    public static By USERNAME_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_username')]");
    public static By NAME_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_name')]");
    public static By SURNAME_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_surname')]");
    public static By MIDDLENAME_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_middle_name')]");
    public static By REGISTRATION_BONUS_RADIO = By.xpath("//input[@id='bonus-35']/following-sibling::label");
    public static By PROMO_CODE_RADIO = By.id("promo_code");
    public static By PROMO_CODE_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_birthday')]");//incompleto
    public static By BONUS_ZERO_RADIO = By.xpath("//input[@id='bonus-0']/following-sibling::label");
    public static By RECEIVE_NEWS_PROMOTIONS_CHECK = By.xpath("//input[contains(@id,'Form_RegistrationForm_subscribe_news')]/following-sibling::label");
    public static By BIRTHDAY_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_birthday')]");
    public static By DATEPICKERS_CONTAINER = By.id("datepickers-container");
    public static By NICKNAME_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_nickname')]");
    public static By ADDRESS_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_address')]");
    public static By COUNTRY_SELECT_INPUT = By.xpath("//select[contains(@id,'Form_RegistrationForm_country')]");
    public static By CITY_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_city')]");
    public static By POSTAL_CODE_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_postcode')]");
    public static By GENDER_SELECT = By.xpath("//select[contains(@id,'Form_RegistrationForm_sex')]");
    public static By SECRET_QUESTION_SELECT = By.xpath("//select[contains(@id,'Form_RegistrationForm_secret_question')]");
    public static By ANSWER_INPUT = By.xpath("//input[contains(@id,'Form_RegistrationForm_secret_answer')]");
    public static By REGISTRATION_BUTTON = By.xpath("//form[@id='registration_form_1']//button");

}