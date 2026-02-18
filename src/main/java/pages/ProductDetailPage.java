package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class ProductDetailPage extends SeleniumHelper {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public static By productName = By.xpath("//*[@id=\"container\"]/main/div/div[2]/section[1]/div[2]/div[1]/div[1]/h1");
    public static By addToCartBtn = By.cssSelector("button[data-test-id=\"addToCart\"]");
    public static By urunSepetinizdeText = By.xpath("//span[starts-with(@class,\"checkoutui-ProductOnBasketHeader-\")]");


    public boolean verifyProductName(){
        waitForElement(productName,"visible");
        waitForElement(addToCartBtn,"visible");
        if(driver.findElement(productName).getText().contains(tempText)){
            return true;
        }else{
            return false;
        }
    }

    public void addToCart(){
        waitForElement(addToCartBtn,"clickable");
        clickElement(addToCartBtn);
    }

    public boolean verifyAddedToCard(){
        waitForElement(urunSepetinizdeText,"visible");
        if(driver.findElement(urunSepetinizdeText).getText().contains("Ürün sepetinizde")){
            return true;
        }else{
            return false;
        }
    }

}
