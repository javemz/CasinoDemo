package ui;

import org.openqa.selenium.By;

public class HomeUI {

    public static By CATEGORIES = By.cssSelector("a[class='nav-menu-categories-link']");
    public static By GAMES = By.linkText("Games");
    public static By TOURNAMENTS = By.linkText("Tournaments");
    public static By SPORT = By.linkText("Sport");
    public static By MORE = By.className("header-menu-main__item-link menu-dd__button");
    public static By BONUSES = By.linkText("Bonuses");
    public static By FAQ = By.linkText("FAQ");
    public static By EVENTS = By.linkText("Events");
    public static By CONTACTS = By.linkText("Contacts");
    public static By SEARCH_WRAPPER = By.className("search__wrapper");
    public static By SING_BUTTON = By.xpath("//div[@class='header__bottom']/div[@class='header--right']/a[1]");
    public static By REGISTRATION_BUTTON = By.xpath("//div[@class='header__bottom']/div[@class='header--right']/a[2]");
    public static By LANGUAGE_SELECT = By.className("lang-select");
    public static By BUY_CREDITS_LINK = By.xpath("//div[@class='header__bottom']//a[@class='header-user__transactions']");

}
