package web.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePageTest {

    protected WebDriver driver;
    public static final Logger log = LoggerFactory.getLogger(HomePageTest.class);


    @BeforeMethod
//    public void setup() {
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // for CI
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void logTestResult(ITestResult result){
        String status;
        switch(result.getStatus()){
            case ITestResult.SUCCESS: status = "SUCCESS"; break;
            case ITestResult.FAILURE: status = "FAILURE"; break;
            case ITestResult.SKIP: status = "SKIPPED"; break;
            default: status = "UNKNOWN"; break;
        }
        log.info("Test '{}' finished with status: {}", result.getMethod().getMethodName(), status);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}