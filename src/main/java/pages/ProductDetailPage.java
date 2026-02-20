package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class ProductDetailPage extends SeleniumHelper {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public static By productName = By.xpath("//*[@id=\"container\"]/main/div/div[2]/section[1]/div[2]/div[1]/div[1]/h1");
    public static By addToCartBtn = By.cssSelector("#container > main > div > div:nth-child(2) > section div[data-test-id=\"add-to-cart\"] button");
    public static By urunSepetinizdeText = By.xpath("//span[starts-with(@class,\"checkoutui-ProductOnBasketHeader-\")]");
    //public static By saticiyaSorDiv = By.cssSelector("div[data-test-id=\"AskToSellerVoltran\"]>div>cst-asktoseller-button");
    public static By urunFiyat = By.cssSelector("main div[data-test-id=\"price\"]");
    public static By premiumIleLink = By.xpath("//div[starts-with(@id,'pdppremiumbanner_')]//a");
    public static By modalSepeteGitBtn = By.xpath("//div[starts-with(@id,'AddToCart_')]//div/div/div/div//button[text()='Sepete git']");
    public static By smallGoToCartPopUpLink = By.cssSelector("a[href=\"https://checkout.hepsiburada.com\"]");

    public boolean verifyProductName(){
        String detailText = driver.findElement(productName).getText();
        String searchText = tempText;

        int middleIndex = detailText.length() / 2;
        String detailHalf = detailText.substring(middleIndex);

        if (searchText.toLowerCase().contains(detailHalf.toLowerCase())) {
            System.out.println("Ürün adı kontrol edildi.");
            System.out.println("Search Page = " + searchText);
            System.out.println("Detail Page = " + detailText);
            return true;
        } else {
            System.out.println("Search Page = " + searchText);
            System.out.println("Detail Page = " + detailText);
            return false;
        }
    }

    public void addToCart() throws InterruptedException {
        //Metodun amacı :Ürün detay sayfasında sepete eklendikten sonra açılan popup bazen açılmıyor.
        //O durumda açılan küçük popuptan devam ediliyor. Istisna dönüp testin patlamasını engelliyor.
        waitForElement(addToCartBtn,"presence");
        waitForElement(urunFiyat,"visible");
        waitForElement(addToCartBtn,"clickable");
        waitForElement(premiumIleLink,"presence");
        waitForElement(premiumIleLink,"clickable");
        clickElement(addToCartBtn);
        try {
            goToCart();
        } catch (NoSuchElementException e) {
            clickElementIsDisplay(smallGoToCartPopUpLink);
        } catch (Exception e){
            driver.get("https://checkout.hepsiburada.com/");
        }
        //Thread.sleep(10000);
        //Thread.sleep(200000);
    }

    private void goToCart() throws InterruptedException {
        waitForElement(urunSepetinizdeText,"visible");
        waitForElement(modalSepeteGitBtn,"visible");
        waitForElement(modalSepeteGitBtn,"clickable");
        clickElement(modalSepeteGitBtn);
        //Thread.sleep(10000);
        //Thread.sleep(200000);
    }



}
