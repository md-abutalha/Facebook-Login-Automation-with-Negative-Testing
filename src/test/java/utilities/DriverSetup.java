package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {

    private static String browserName = System.getProperty("browser", "chrome"); // Correctly retrieves the browser name
    private static final ThreadLocal<WebDriver> LOCAL_THREAD = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_THREAD.set(driver);
    }

    public static WebDriver getDriver() {
        return LOCAL_THREAD.get();
    }

    public WebDriver getBrowser(String browser_name) {
        if (browser_name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browser_name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (browser_name.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Browser not available: " + browser_name);
        }
    }

    @BeforeMethod
    public void openBrowser() {
        WebDriver driver = getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void closeDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
