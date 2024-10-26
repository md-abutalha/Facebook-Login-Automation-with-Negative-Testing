package testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @AfterMethod
    public void addScrrenshotsOfTest(){
        homePage.addScreenshot();
    }
    @Test(priority = 1)
    public void testLoginWithValidCredentials() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "013101055464");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getElement(loginPage.errorMessage).getText(),"Wrong credentials\n" +
                "Invalid username or password");
    }

    @Test(priority = 2)
    public void testLoginWithLongEmail() throws InterruptedException {
        getDriver().get(homePage.url);
        StringBuilder longEmail = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            longEmail.append("a");
        }
        homePage.writeOnElement(loginPage.loginEmail, longEmail.toString() + "@example.com");
        homePage.writeOnElement(loginPage.loginPassword, "asfsfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 3)
    public void testLoginWithLongPassword() throws InterruptedException {
        getDriver().get(homePage.url);
        StringBuilder longPassword = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            longPassword.append("talha");
        }
        homePage.writeOnElement(loginPage.loginEmail, "013101435345");
        homePage.writeOnElement(loginPage.loginPassword, longPassword.toString());
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 4)
    public void testLoginWithSpacesOnlyInPassword() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "01310105355");
        homePage.writeOnElement(loginPage.loginPassword, "     ");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 5)
    public void testLoginWithSpacesOnlyInEmail() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "     ");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 6)
    public void testLoginWithScriptInjectionInEmail() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "<script>alert('test')</script>");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 7)
    public void testLoginWithSQLInjectionInEmail() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "admin' OR '1'='1");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 8)
    public void testLoginWithInvalidPhoneFormat() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "123abc!@#");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 9)
    public void testLoginWithWhitespaceInPassword() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "01310105355");
        homePage.writeOnElement(loginPage.loginPassword, " allahgfhd ");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 10)
    public void testLoginWithSpecialCharactersInPassword() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "01310105355");
        homePage.writeOnElement(loginPage.loginPassword, "!@#$%^&*()");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 11)
    public void testLoginWithWhitespaceInEmail() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, " 01310105355 ");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 12)
    public void testLoginWithEmptyCredentials() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "");
        homePage.writeOnElement(loginPage.loginPassword, "");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

    @Test(priority = 13)
    public void testLoginWithInvalidEmailFormat() throws InterruptedException {
        getDriver().get(homePage.url);
        homePage.writeOnElement(loginPage.loginEmail, "invalidEmail");
        homePage.writeOnElement(loginPage.loginPassword, "allahgfhd");
        loginPage.clickElement(loginPage.loginSubmit);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMessage).isDisplayed());
    }

// Create by Abu Talha :>
}
