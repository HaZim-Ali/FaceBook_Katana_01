package Locators;

import StepDefinitions.Hooks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Registration_Locator {


    AndroidDriver driver = Hooks.HZM;

    public WebElement CreateNewAccount (){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Create New Facebook Account\"]"));
    }
    public WebElement NextBut (){
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
    }
    public WebElement AccountAuto (){
        return driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"HaZim Aly\"]/android.widget.LinearLayout/android.widget.LinearLayout"));
    }
    public WebElement NextAuto (){
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
    }
}
