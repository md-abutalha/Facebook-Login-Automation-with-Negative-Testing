package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url = "https://www.facebook.com/";
    public String pageTitle = "Facebook – log in or sign up";

    public By loginButton = By.xpath("//button[@id='u_0_5_Y5']");

    public void loadHomePage(){
        loadWebPage(url);
    }
}
