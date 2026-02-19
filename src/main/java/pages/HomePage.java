package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class HomePage extends SeleniumHelper {

    private static By homePageIconLink = By.cssSelector("a[title=\"Hepsiburada\"]");
    private static By odlHeader = By.xpath("//div[starts-with(@id,'oldHeader_')]");
    private static By homePageSearchBar = By.cssSelector("div#searchBoxOld input");
    private static By searchBarAfterClick= By.cssSelector("div[class=\"searchBarContent-jBWeGeiNJ07s_RubCRzl searchBarContent-Wl6hIIE3QjA9Nou6rD6j\"]");
    private static By searchBarSendKeyElement = By.cssSelector("div[class=\"searchBarContent-jBWeGeiNJ07s_RubCRzl searchBarContent-Wl6hIIE3QjA9Nou6rD6j\"] input[placeholder=\"Ürün, kategori veya marka ara\"]");
    public static String productName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean iconControl(){
        return waitForElement(homePageIconLink,"visible")!=null;
    }

    public boolean searchBarControl(){
        return waitForElement(homePageSearchBar,"visible")!=null;
    }


    public void sendTextToElement(){
        waitForElement(odlHeader,"visible");
        waitForElement(homePageSearchBar,"clickable");
        //stale element istisnası fırlatmaması için
        //daha önce yüklendiğini düşündüğüm kapsayan elementi bekledi.
        clickElement(homePageSearchBar);
        //elementWaitWithFluent(searchBarSendKeyElement);
        waitForElement(searchBarAfterClick,"visible");
        productName = getRandomProductName();
        driver.findElement(searchBarSendKeyElement).sendKeys(productName);
        driver.findElement(searchBarSendKeyElement).sendKeys(Keys.ENTER);
    }



}
