package com.test.openmrs.stepdefinitions;

import com.test.openmrs.utils.BrowserUtils;
import com.test.openmrs.utils.ConfigReader;
import com.test.openmrs.utils.DriverHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hook {
public WebDriver driver= DriverHelper.getDriver();

@Before
    public void setup(){
    driver.get(ConfigReader.readProperty("QA_OpenMRS_URL"));
}

@After
    public void tearDown(Scenario scenario){
    BrowserUtils.getScreenShotForCucumber(driver,scenario);
    //driver.quit();

}

}
