package StepDefinitions;

import Locators.Registration_Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Registration_Steps {

    Registration_Locator NewAccount = new Registration_Locator();
    Registration_Locator NextButton = new Registration_Locator();
    Registration_Locator AccountAutoFill = new Registration_Locator();
    Registration_Locator NextAutofill = new Registration_Locator();


    @Given("click on create new facebook account")
    public void click_on_create_new_account() throws InterruptedException {
        Thread.sleep(2000);
        NewAccount.CreateNewAccount().click();
        System.out.println("New Registration Form");
    }
    @When("click on Next button to proceed with filling")
    public void click_on_Next_button(){
        NextButton.NextBut().click();
    }
    @And("select your account")
    public void select_account(){
        AccountAutoFill.AccountAuto().click();
    }
    @And("click on Next AutoFill")
    public void Next_Autofill (){
        NextAutofill.NextAuto().click();
    }

}
