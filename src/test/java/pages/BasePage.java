package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import java.io.ByteArrayInputStream;

public class BasePage extends DriverSetup {

    //Locator
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    //Click
    public void clickElement(By locator) {
        getElement(locator).click();
    }

    // SenKeys
    public void writeOnElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    //pageUrl
    public String getPageUrl() {
        return getDriver().getCurrentUrl();
    }

    //pageTitle
    public String getPageTitle() {
        return getDriver().getTitle();
    }

    // isDisplayed
    public boolean isElementDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //page url 18 tharik class
    public void loadWebPage(String url) {
        getDriver().get(url);
    }
    //page url 18 tharik class
    public void addScreenshot() {
        Allure.addAttachment("After Test", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
