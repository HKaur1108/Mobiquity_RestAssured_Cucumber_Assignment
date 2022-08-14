package com.jsonplaceholder.steps;

import com.jsonplaceholder.domain.helper.JsonHolderService;
import com.jsonplaceholder.domain.response.PostResponse;
import com.jsonplaceholder.domain.response.UserResponse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;


public class JsonSteps {
    private JsonHolderService jsonHolderService;
    private UserResponse user;
    private String userId;
    private String username;
    private ArrayList<String> postIDs;
    private PostResponse[] post_Details;
    private ArrayList<String> allEmails;
    private boolean areAllofTheEmailsValid;

    public JsonSteps(JsonHolderService jsonHolderHelper) {
        this.jsonHolderService = jsonHolderHelper;

    }

    @Given("^I search for User \"([^\"]*)\"$")
    public void iSearchForUser(String name) {
        user = jsonHolderService.findUserWithUserName(name);

    }


    @Then("^Verify if user \"([^\"]*)\" exists \"([^\"]*)\"$")
    public void verify_if_user_something_exists_something(String name, String existStatus) throws Throwable {

        if (user.getUsername() != "") {
            username = user.getUsername();
            Assert.assertEquals(name, username);

        } else {
            Assert.assertEquals(existStatus, "NotExist");
        }
    }

    @When("^I find user \"([^\"]*)\"$")
    public void iFoundUser(String name) {
        if (user.getUsername() != null) {
            username = user.getUsername();
            Assert.assertEquals(name, username);
        }

    }

    @Given("^I have userId for \"([^\"]*)\"$")
    public void i_have_userId_for_a_specific_user(String name) throws Throwable {
        user = jsonHolderService.findUserWithUserName(name);
        userId = user.getId();
    }

    @Then("^Verify userId (.+) for \"([^\"]*)\"$")
    public void verify_userid_for_something(String expected_UserId, String name) throws Throwable {
        Assert.assertEquals(expected_UserId,userId);
    }

    @When("^I query  posts for specific user with userid parameter$")
    public void i_query_Users_posts() throws Throwable {
        postIDs = jsonHolderService.fetchAllPostIdsForUser(userId);
    }

    @Then("^Verify the count of Post (.+) for user with (.+)$")
    public void verify_the_count_of_post_for_user_with(int postcount, String userid) throws Throwable {
        Assert.assertEquals( postcount,postIDs.size());
    }

    @Then("^Verify user should get (.+) emails$")
    public void user_should_get_all_postIds_for_that_userId(String totalemails) throws Throwable {
        allEmails = jsonHolderService.fetchAllEmailsForAllCommentsForAUser(userId);
        Assert.assertEquals(Integer.parseInt(totalemails), allEmails.size());
    }

    @When("^I check all email addresses$")
    public void i_check_all_email_addresses() throws Throwable {
        allEmails = jsonHolderService.fetchAllEmailsForAllCommentsForAUser(userId);
        areAllofTheEmailsValid = jsonHolderService.verifyAllEmails(allEmails);
    }

    @Then("^I should have all email addreses in valid format$")
    public void i_should_have_all_email_addreses_in_valid_format() throws Throwable {
        Assert.assertEquals(areAllofTheEmailsValid, true);
    }


//
}
