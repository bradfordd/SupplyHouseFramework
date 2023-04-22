package StepDefinitions;

import automationUtils.RunWeb;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModels.SupplyHouseHomePage;

public class itemCatalogueSteps extends RunWeb{

    @When("^User Selects (.*) at the HomePage$")
    public void userSelectsBrandAtHomePage(String brand) {
        //s = new SupplyHouseHomePage(driver);
    }

    @When("^User selects the following parameters: (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userSelectsParameters(String inStockOnly, String productType, String priceRange, String reviewScore, String application, String material, String size) {
        // Your implementation here
    }

    @Then("^Products with specifications are displayed$")
    public void productDetailsPageIsDisplayed() {
        // Your implementation here
    }
}
