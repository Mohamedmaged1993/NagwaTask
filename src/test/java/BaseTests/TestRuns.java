package BaseTests;

import PageObjects.EnglishHomePage;
import PageObjects.HomePage;
import PageObjects.SearchResultsURL;
import Utilities.ObjectRepo;
import Utilities.PropertiesConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestRuns {


    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    EnglishHomePage englishHomePage ;
    SearchResultsURL searchResultsURL;
    PropertiesConfig propertiesConfig;
    int timeOut = 10;

    @BeforeClass
    public void beforeclass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, timeOut);
        homePage = new HomePage(driver);
        englishHomePage = new EnglishHomePage(driver);
        searchResultsURL = new SearchResultsURL(driver);
        propertiesConfig = new PropertiesConfig();
        driver.get(propertiesConfig.getProperty("navigateUrl"));
    }

    @Test(priority = 1)
    public void successfulTest() {
        homePage.selectEnglishLang();
        englishHomePage.selectSearchIcon();
        englishHomePage.fillSearchData(propertiesConfig.getProperty("validSearchInput"));
        englishHomePage.selectSearchField();
        searchResultsURL.selectSecondOption(1);
        searchResultsURL.previewClickBTN();
        searchResultsURL.countsQuestions();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
