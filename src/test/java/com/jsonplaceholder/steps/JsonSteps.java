package com.jsonplaceholder.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;


public class JsonSteps {


    @Given("^I search for User \"([^\"]*)\"$")
    public void iSearchForUser(String name) throws Throwable {
        throw new PendingException();
    }


    @Then("^Verify if user \"([^\"]*)\" exists \"([^\"]*)\"$")
    public void verify_if_user_something_exists_something(String name, String existStatus) throws Throwable {
        throw new PendingException();
    }

    @When("^I find user \"([^\"]*)\"$")
    public void iFoundUser(String name) throws Throwable {
        throw new PendingException();
    }

    @Given("^I have userId for \"([^\"]*)\"$")
    public void i_have_userId_for_a_specific_user(String name) throws Throwable {
        throw new PendingException();
    }

    @Then("^Verify userId (.+) for \"([^\"]*)\"$")
    public void verify_userid_for_something(String expected_UserId, String name) throws Throwable {
        throw new PendingException();
    }

    @When("^I query  posts for specific user with userid parameter$")
    public void i_query_Users_posts() throws Throwable {
        throw new PendingException();
    }

    @Then("^Verify the count of Post (.+) for user with (.+)$")
    public void verify_the_count_of_post_for_user_with(int postcount, String userid) throws Throwable {
        throw new PendingException();
    }

    @Then("^Verify user should get (.+) emails$")
    public void user_should_get_all_postIds_for_that_userId(String totalemails) throws Throwable {
        throw new PendingException();
    }

    @When("^I check all email addresses$")
    public void i_check_all_email_addresses() throws Throwable {
        throw new PendingException();
    }

    @Then("^I should have all email addreses in valid format$")
    public void i_should_have_all_email_addreses_in_valid_format() throws Throwable {
        throw new PendingException();
    }

}
