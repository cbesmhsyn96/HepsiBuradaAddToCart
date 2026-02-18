package cart;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchResultsPage;
import utils.OtherHelper;
import utils.SeleniumHelper;

import static pages.HomePage.productName;
import static pages.SearchResultsPage.*;
import static utils.OtherHelper.getRandomProductName;


public class Cart extends BaseTest {
    public static HomePage homePage;
    public static SearchResultsPage searchResultsPage;
    public static SeleniumHelper seleniumHelper;
    public static ProductDetailPage productDetailPage;
    public static OtherHelper otherHelper;
    private static Assertions assertions;
    @Test
    public void searchProductAddToCart() throws InterruptedException {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        seleniumHelper = new SeleniumHelper(driver);
        productDetailPage = new ProductDetailPage(driver);
        homePage.goToUrl("https://www.hepsiburada.com/");
        homePage.iconControl();
        homePage.searchBarControl();
        homePage.sendTextToElement();
        searchResultsPage.controlSearchResultHeader();
        searchResultsPage.horizontalSortingBarControl();
        searchResultsPage.stickyVerticalFilterControl();
        searchResultsPage.productListContainerControl();
        Assertions.assertTrue(seleniumHelper.isContainedTheTextByLocator(searchedProductHeader,homePage.productName),"Arama sonuçları sayfası doğru açılmadı.");
        searchResultsPage.goRandomProductDetailPage();
        seleniumHelper.switchToLastTab();
        Assertions.assertTrue(productDetailPage.verifyProductName(),"Ürün detay sayfasına gidilemedi.");
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.verifyAddedToCard(),"Ürün sepete eklenmedi.");
    }
}
