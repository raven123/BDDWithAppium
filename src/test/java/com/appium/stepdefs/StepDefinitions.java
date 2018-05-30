package com.appium.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	@Given("^I have logged in to the application$")
	public void i_have_logged_in_to_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//sthrow new PendingException();
	}

	@Given("^I have selected my location$")
	public void i_have_selected_my_location() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^I input the \"([^\"]*)\" into the search bar$")
	public void i_input_the_into_the_search_bar(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^I should get search results list for the same$")
	public void i_should_get_search_results_list_for_the_same() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
