package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class ProductDetailPage extends SeleniumHelper {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public static By productName = By.xpath("//*[@id=\"container\"]/main/div/div[2]/section[1]/div[2]/div[1]/div[1]/h1");
    public static By addToCartBtn = By.cssSelector("#container > main > div > div:nth-child(2) > section div[data-test-id=\"add-to-cart\"] button");
    public static By urunSepetinizdeText = By.xpath("//span[starts-with(@class,\"checkoutui-ProductOnBasketHeader-\")]");
    public static By saticiyaSorDiv = By.cssSelector("div[data-test-id=\"AskToSellerVoltran\"]>div>cst-asktoseller-button");
    public static By urunFiyat = By.cssSelector("main div[data-test-id=\"price\"]");
    public static By premiumIleLink = By.xpath("//div[starts-with(@id,'pdppremiumbanner_')]//a");
    public static By modalSepeteGitBtn = By.xpath("//div[starts-with(@id,'AddToCart_')]//div/div/div/div//button[text()='Sepete git']");
    public boolean verifyProductName(){
        waitForElement(productName,"presence");
        scrollToElement(driver,productName);
        if(driver.findElement(productName).getText().contains(tempText)){
            return true;
        }else{
            return false;
        }
    }

    public void addToCart() throws InterruptedException {
        waitForElement(urunFiyat,"presence");
        waitForElement(saticiyaSorDiv,"presence");
        waitForElement(addToCartBtn,"presence");
        waitForElement(premiumIleLink,"presence");
        //waitForElement(odemeAyarlari,"presence");
        //waitForElement(variantName,"visible");
        clickElement(addToCartBtn);
        waitForElement(urunSepetinizdeText,"visible");
        waitForElement(modalSepeteGitBtn,"visible");
        //Thread.sleep(10000);
        //Thread.sleep(200000);
    }

    public void goToCart() throws InterruptedException {
        waitForElement(urunSepetinizdeText,"visible");
        waitForElement(modalSepeteGitBtn,"visible");
        waitForElement(modalSepeteGitBtn,"clickable");
        clickElement(modalSepeteGitBtn);
        //Thread.sleep(10000);
        //Thread.sleep(200000);
    }



}
