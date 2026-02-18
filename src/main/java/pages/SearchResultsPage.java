package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class SearchResultsPage extends SeleniumHelper {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    //"Harici disk" araması

    public static By searchedProductHeader = By.cssSelector("h1[data-test-id=\"header-h1\"]");
    public static By horizontalSortingBar = By.xpath("//div[starts-with(@id,'SortingBox_')]");
    public static By productListContainer = By.xpath("//div[starts-with(@id,'ProductList_')]");
    public static By productNameList = By.xpath("//div[starts-with(@id,'ProductList_')]//ul/li//div[starts-with(@class,'productCard-')]/a");
    public static By stickyVerticalFilter = By.id("stickyVerticalFilter");
    public static By stickyFilterCategoryContaioner = By.xpath("(//div[@id=\"stickyVerticalFilter\"]//div[@id=\"AllCategories.CategoryId\"])[1]");
    public static By stickyFilterSearchBar = By.cssSelector("div[id=\"markalar\"] input[placeholder=\"Filtrele\"]");
    public static By firstBrandVerticalMenu = By.xpath("(//*[@id='markalar']//label[starts-with(@class,'checkbox-')])[1]");

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

    public void goRandomProductDetailPage() throws InterruptedException {
        selectRandomItemInList(productNameList);
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
