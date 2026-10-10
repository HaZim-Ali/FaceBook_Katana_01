package Locators;

import StepDefinitions.Hooks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_Locator {

    AndroidDriver driver = Hooks.HZM;

    public WebElement MobileNumber() {
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username\"]"));
    }
    public WebElement Passwords (){
        return driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password\"]"));
    }
    public WebElement LoginButt (){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Log In\"]"));
    }


}
