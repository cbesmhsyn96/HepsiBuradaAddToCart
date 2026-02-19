package cart;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchResultsPage;
import utils.OtherHelper;
import utils.SeleniumHelper;

import static pages.HomePage.productName;
import static pages.SearchResultsPage.*;


public class Cart extends BaseTest {
    public static HomePage homePage;
    public static SearchResultsPage searchResultsPage;
    public static SeleniumHelper seleniumHelper;
    public static ProductDetailPage productDetailPage;
    public static CartPage cartPage;
    public static OtherHelper otherHelper;
    private static Assertions assertions;
    @Test
    public void searchProductAddToCart() throws InterruptedException {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        seleniumHelper = new SeleniumHelper(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        homePage.goToUrl("https://www.hepsiburada.com/");
        homePage.iconControl();
        homePage.searchBarControl();
        homePage.sendTextToElement();
        searchResultsPage.controlSearchResultHeader();
        searchResultsPage.horizontalSortingBarControl();
        searchResultsPage.stickyVerticalFilterControl();
        searchResultsPage.productListContainerControl();
        Assertions.assertTrue(seleniumHelper.isContainedTheTextByLocator(searchedProductHeader,homePage.productName),"Arama sonuçları sayfası doğru açılmadı.");
        searchResultsPage.selectRandomBrandInVerticalMenu();
        seleniumHelper.refreshPage();
        searchResultsPage.verifySelectedBrandInList();
        searchResultsPage.goRandomProductDetailPage();
        seleniumHelper.switchToLastTab();
        boolean verifyState = productDetailPage.verifyProductName();
        Assertions.assertTrue(verifyState,"Ürün detay sayfasına gidilemedi.");
        seleniumHelper.refreshPage();
        productDetailPage.addToCart();
        Assertions.assertTrue(cartPage.verifyOpenedCartPage(),"Sepet sayfasına gidilemedi.");
        Assertions.assertTrue(cartPage.verifyProductNameInCart(),"Ürün sepet sayfasına gitmedi(ürün adı görünmüyor)");
    }
}
