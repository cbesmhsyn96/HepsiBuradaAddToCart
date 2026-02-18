package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumHelper;

import java.time.Duration;

public class BaseTest{
    protected WebDriver driver;
    protected SeleniumHelper helper;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        // Helper örneğini driver ile oluşturuyoruz
        helper = new SeleniumHelper(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
