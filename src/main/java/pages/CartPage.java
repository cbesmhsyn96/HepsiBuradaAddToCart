package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class CartPage extends SeleniumHelper {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public static By spetimYazisiHeader = By.xpath("//header//h1");
    public static By productDueDate = By.xpath("//div[starts-with(@class,'product_duedate_wrapper_')]//span");
    public static By couponsTitle = By.xpath("//div[starts-with(@class,'main_content_')]//div[starts-with(@class,'title_container_')]");
    public static By productName = By.xpath("//div[starts-with(@class,'product_properties_')]/div/a");

    public boolean verifyOpenedCartPage(){
        boolean sepetimHeaderState = waitForElement(spetimYazisiHeader,"visible")!=null;
        boolean productDueDateState = waitForElement(productDueDate,"visible")!=null;
        boolean couponsTitleState = waitForElement(couponsTitle,"visible")!=null;
        if(sepetimHeaderState&&productDueDateState&&couponsTitleState){
            return true;
        }else{
            return false;
        }
    }


    public boolean verifyProductNameInCart(){
        waitForElement(productName,"visible");
        /*System.out.println("verifyProductNameInCart");
        System.out.println(driver.findElement(productName).getText());
        System.out.println(tempText);
        System.out.println("verifyProductNameInCart");*/

        //temptext arama sonuç sayfasında listelenen ürünlerden rastgele seçilenin adı
        //SeleniumHelper.java da temptext e bu değer atandı.
        if(driver.findElement(productName).getText().contains(tempText)){
            return true;
        }else{
            return false;
        }
    }
}
