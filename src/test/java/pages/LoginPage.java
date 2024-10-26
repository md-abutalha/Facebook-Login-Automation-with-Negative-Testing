package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    HomePage homePage = new HomePage();

    public By loginEmail = By.xpath("//input[@id='email']");
    public By loginPassword = By.xpath("//input[@id='pass']");
    public By loginSubmit = By.xpath("//button[@name='login']");  // Updated to use name attribute
    public By errorMessage = By.xpath("//div[@id='error_box']");
    public By forgetPassword = By.xpath("//a[normalize-space()='Forgotten password?']");
}
