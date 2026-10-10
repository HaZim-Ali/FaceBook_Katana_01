package StepDefinitions;

import Locators.Login_Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Login_Steps {

    Login_Locator loginLocator = new Login_Locator();
    Login_Locator Password = new Login_Locator();
    Login_Locator LoginButton = new Login_Locator();
    Login_Locator InvalidMobile = new Login_Locator();
    Login_Locator InvalidPassword = new Login_Locator();

    String mobileNumber = "1111155856";
    String PasswordsLogin = "852963741";

    @When("clint enters mobile number")
    public void clint_enters_mobile_number() throws InterruptedException {
        Thread.sleep(2000);
        loginLocator.MobileNumber().sendKeys(mobileNumber);
        System.out.println("📱 Entered mobile number: " + mobileNumber);
    }
    @And("clint fill passwords")
    public void clint_fill_passwords() throws InterruptedException {
        Thread.sleep(2000);
        Password.Passwords().sendKeys(PasswordsLogin);
        System.out.println("📲 Password Validation" + PasswordsLogin);
    }
    @And("clint click on login button")
    public void clint_click_on_login_button() throws InterruptedException {
        Thread.sleep(2000);
        LoginButton.LoginButt().click();
    }
    @When("clint enters {string}")
    public void clint_enter(String Invalidmobilenumber){
        InvalidMobile.MobileNumber().sendKeys(Invalidmobilenumber);
    }
    @And("clint fill {string}")
    public void clint_fill(String Invalidpassword){
        InvalidPassword.Passwords().sendKeys(Invalidpassword);

    }
    }

