package com.test.openmrs.stepdefinitions;

import com.test.openmrs.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {

    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @When("User provides username and password")
    public void user_provides_and() {
        loginPage.provideCredentials(ConfigReader.readProperty("QA_UserName"),ConfigReader.readProperty("QA_Password"));
    }

    @When("User chooses location {string} and clicks login button")
    public void user_chooses_location_laboratory_and_clicks_login_button(String location) {
   loginPage.login(location);
    }
    @Then("User successfully navigates to {string} page")
    public void user_successfully_navigates_to_page(String title) {
        loginPage.validateTitle(driver,title);
    }
    @When("User provides {string} and {string}")
    public void user_provides_and(String username, String password) {
        loginPage.provideCredentials(username,password);

    }
    @Then("User gets a error message {string}")
    public void user_gets_a_error_message(String expectedErrorMessage) {
        loginPage.validateErrorMessage(expectedErrorMessage);

    }
}
