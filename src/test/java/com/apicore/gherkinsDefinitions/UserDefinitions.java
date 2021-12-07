package com.apicore.gherkinsDefinitions;

import com.apicore.serenitySteps.UserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * This is class contains user definitions
 */

public class UserDefinitions {

    @Steps
    public UserSteps userSteps;

    @And("^user gets profile information$")
    public void getProfile() throws Exception{
        userSteps.getProfile();
    }

    @Then("^user creates profile with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void createUser(String name, String email, String gender, String status) throws Exception {
        userSteps.createProfile(name,email,gender,status);

    }

    @Then("^the user deletes profile$")
    public void theUserDeletesProfile() throws Exception {
        userSteps.removeUserProfile();
    }

    @When("^user updates profile name with \"([^\"]*)\"$")
    public void userUpdatesProfileNameWith(String newName) throws Exception {
        userSteps.updateUserProfileName(newName);

    }

    @When("^user creates new profile with \"([^\"]*)\", already used \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void userCreatesAdditionalProfileWithAlreadyExistingEmail(String newName, String email, String newGender, String newStatus) throws Exception {
        userSteps.userCreatesAdditionalProfileWithAlreadyExistingEmail(newName,email,newGender,newStatus);

    }

    @Then("^the user deletes already deleted profile$")
    public void theUserDeletesAlreadyDeletedProfile() throws Exception {
        userSteps.removeUserProfile();
    }
}
