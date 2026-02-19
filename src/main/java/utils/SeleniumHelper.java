package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchResultsPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class SeleniumHelper extends OtherHelper{
    /*
    Bu sınıfta kapsayıcı metotlarla kod tekrarını önlemek amaçlandı.
     */

    protected static WebDriver driver;
    protected static FluentWait<WebDriver> wait;
    protected static int randomIndex;
    protected static String tempText;
    protected static String selectedText;
    protected static String getTempText;
    protected static int productIndex;
    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Element state kontrolü
    public boolean checkState(By by, String state) {
        WebElement element = driver.findElement(by);
        switch (state) {
            case "displayed": return element.isDisplayed();
            case "enabled": return element.isEnabled();
            case "selected": return element.isSelected();
            default: return false;
        }
    }

    // Tüm attribute isimlerini al
    public List<String> getAllAttributeNames(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> attributes = new ArrayList<>();

        if (waitForElement(by,"presence")!=null) { //bulursa al
            List<String> jsAttributes = (List<String>) js.executeScript(
                    "return Array.from(arguments[0].attributes).map(attr => attr.name);",
                    element
            );
            if (jsAttributes != null) attributes.addAll(jsAttributes);
        }

        return attributes;
    }

    public boolean isExistAttributeByLocator(By by, String content){
        //Attribute kontrolü
        List<String> attributes = getAllAttributeNames(by);
        if (attributes != null && attributes.contains(content)) {
            return true;
        }else{
            return false;
        }
    }

    public String saveElementTitle(By by){
        WebElement element = driver.findElement(by);
        tempText = element.getAttribute("title");
        System.out.println(tempText);
        return tempText;
    }

    public boolean isNotContainedTitleTextByLocator(By by, String content){
        WebElement element = driver.findElement(by);
        if (!element.getAttribute("title").contains(content)) {
            System.out.println("Get text = "+element.getAttribute("title")+" == aynı değil ==="+content);
            return true;
        }else{
            return false;
        }
    }

    public boolean isContainedTheTextByLocator(By by, String content){
        WebElement element = driver.findElement(by);
        //Text kontrolü
        if (element.getText().contains(content)) {
            //System.out.println("Get text = "+element.getText()+" "+content);
            return true;
        }else{
            return false;
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public WebElement waitForElement(By by, String condition) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        switch (condition) {
            case "clickable":
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case "visible":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case "presence":
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            default:
                throw new IllegalArgumentException("Invalid wait condition");
        }
    }

    public void clickElement(By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    public void clickElementWebElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", wait.until(ExpectedConditions.elementToBeClickable(element)));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    public void selectRandomItemInList(By by,String attribute){
        random = new Random();
        randomIndex=0;
        List<WebElement> elements = driver.findElements(by);
        randomIndex = random.nextInt(elements.size());
        scrollToElementWithElement(driver,elements.get(randomIndex));
        try {
            getTempText = elements.get(randomIndex).getAttribute(attribute);
            System.out.println("getTempText = "+getTempText);
        } catch (Exception e) {
        }
        clickElementWebElement(elements.get(randomIndex));
    }

    public void clickElementIsDisplay(By by){
        WebElement element = driver.findElement(by);
        waitForElement(by,"clickable");
        try{
            if(element.isDisplayed()){
                element.click();
            }
        }catch (Exception e){
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        }

    }

    public String getTitleRondomElementList(By by){

        random = new Random();
        randomIndex=0;
        List<WebElement> elements = driver.findElements(by);
        randomIndex = random.nextInt(elements.size());

        //System.out.println(elements.get(randomIndex).getText());
        tempText = "";
        //Burada arama sonuç sayfasında listelenen ürünlerden rastgele seçilenin adı temptext e alınıyor.
        tempText = elements.get(randomIndex).getAttribute("title");
        //System.out.println("selectRondomElementInList -- randomIndex(search product list) = "+randomIndex);
        return tempText;
    }

    public void selectElementByIndexInList(By by ,int index){
        List<WebElement> elements = driver.findElements(by);
        clickElementWebElement(elements.get(index));
    }

    public void scrollToElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToElementWithElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}
