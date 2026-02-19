package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumHelper;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SearchResultsPage extends SeleniumHelper {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public static By searchedProductHeader = By.cssSelector("h1[data-test-id=\"header-h1\"]");
    public static By horizontalSortingBar = By.xpath("//div[starts-with(@id,'SortingBox_')]");
    public static By productListContainer = By.xpath("//div[starts-with(@id,'ProductList_')]");
    public static By productNameList = By.xpath("//div[starts-with(@id,'ProductList_')]//ul/li//div[starts-with(@class,'productCard-')]/a");
    public static By stickyVerticalFilter = By.id("stickyVerticalFilter");
    public static By stickyFilterCategoryContaioner = By.xpath("(//div[@id=\"stickyVerticalFilter\"]//div[@id=\"AllCategories.CategoryId\"])[1]");
    public static By stickyFilterSearchBar = By.cssSelector("div[id=\"markalar\"] input[placeholder=\"Filtrele\"]");
    public static By firstBrandVerticalMenu = By.xpath("//*[@id='markalar']//label[starts-with(@class,'checkbox-')]/input");
    private static By sepetimBtn = By.xpath("//div[starts-with(@id,'oldHeader_')]/div/div//a[@href='https://checkout.hepsiburada.com/sepetim']");
    private static By premiumuKesfetLink = By.xpath("//div[@data-test-id=\"nonPremium-logo\"]//a");
    private static By konumSecDiv = By.xpath("//*[starts-with(@id,\"shippingLocation_\")]/div/div/div/div/div[1]/div");


    public boolean controlSearchResultHeader(){
        return waitForElement(searchedProductHeader,"visible")!=null;
    }
    public boolean horizontalSortingBarControl(){
        return waitForElement(horizontalSortingBar,"visible")!=null;
    }
    public boolean productListContainerControl(){
        return waitForElement(productListContainer,"visible")!=null;
    }
    public boolean stickyVerticalFilterControl(){
        return waitForElement(stickyVerticalFilter,"visible")!=null;
    }
    public boolean stickyFilterCategoryContaionerControl(){
        return waitForElement(stickyFilterCategoryContaioner,"visible")!=null;
    }
    public boolean stickyFilterSearchBarControl(){
        return waitForElement(stickyFilterSearchBar,"visible")!=null;
    }

    public void goRandomProductDetailPage(){
        waitForElement(productNameList, "visible");
        List<WebElement> products = driver.findElements(productNameList);
        //tempText = products.get(productIndex).getText();
        //System.out.println("Bu tempText, ürün detayda doğrulamada kullanılacak -->"+tempText);
        clickElementWebElement(products.get(randomIndex));
    }

    public void selectRandomBrandInVerticalMenu(){
        //stale element reference: stale element not found in the current frame için beklemeler koydum
        waitForElement(sepetimBtn,"visible");
        waitForElement(premiumuKesfetLink,"visible");
        //waitForElement(stickyFilterSearchBar,"visible");
        waitForElement(productNameList,"visible");

        //waitForElement(firstBrandVerticalMenu,"visible");
        //waitForElement(topButtons,"visible");
        waitForElement(firstBrandVerticalMenu,"visible");
        selectRandomItemInList(firstBrandVerticalMenu,"value");
        /*try{


        } catch (Exception e) {
            System.out.println("Marka/Yayınevi seçilmedi.");
        }*/
    }

    public void verifySelectedBrandInList() throws InterruptedException {
        waitForElement(premiumuKesfetLink,"visible");
        waitForElement(konumSecDiv,"visible");
        waitForElement(productNameList,"visible");
        waitForElement(productNameList,"clickable");
        String lowerCaseTitle = driver.findElements(productNameList).getFirst().getAttribute("title").toLowerCase(Locale.ENGLISH);
        String upperCaseTitle = driver.findElements(productNameList).getFirst().getAttribute("title").toUpperCase(Locale.ENGLISH);
        String lowerCaseBrand = getTempText.toLowerCase(Locale.ENGLISH);
        String upperCaseBrand = getTempText.toUpperCase(Locale.ENGLISH);
        getTitleRondomElementList(productNameList);
        if(lowerCaseTitle.contains(lowerCaseBrand)||upperCaseTitle.contains(upperCaseBrand)){
            System.out.println("Marka kontrol edildi");
            System.out.println(driver.findElements(productNameList).getFirst().getAttribute("title")+"==========="+getTempText+"(getTempText) markasını içeriyor.");
        }else{
            System.out.println("Hata ------- "+driver.findElements(productNameList).getFirst().getAttribute("title")+" içermiyor "+getTempText);
        }
    }

    /*public boolean clickFirstBrand() {

        waitForElement(productNameListFirstName,"visible");
        tempText = saveElementTitle(productNameListFirstName);
        clickElement(firstBrandVerticalMenu);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(productNameListFirstName)));

        String newProduct = driver.findElement(productNameListFirstName).getAttribute("title");

        return !tempText.equals(newProduct);
    }*/

    /*public boolean clickSecondBrand(){
        waitForElement(productListContainer,"visible");
        waitForElement(stickyFilterSearchBar,"clickable");
        waitForElement(productNameListFirstName,"visible");

        scrollToElement(driver,firstBrandVerticalMenu);
        waitForElement(firstBrandVerticalMenu,"visible");

        saveElementTitle(productNameListFirstName);

        clickElement(firstBrandVerticalMenu);

        waitForElement(productNameListFirstName,"visible");

        return isNotContainedTitleTextByLocator(productNameListFirstName,tempText);
    }*/


    //selectRandomItemInList



    /*public boolean horizontalSortingBarControl(){
        return elementWaitWithFluent(horizontalSortingBar)!=null;
    }*/




    /*
    1- Selenium Helper da metot ekle. O metodu çağırıp ilerle.
    horizontalSortingBar da rastgele seçim
     */
}
