package com.apicore.serenitySteps;

import com.apicore.requestBodies.UserRequestBody;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    public static final String RESPONSE = "response";

    @Step
    public void getProfile() throws Exception {
        CommonSteps.sendRequest("GET", "/public/v1/users/" + Serenity.sessionVariableCalled("userId"));
    }

    @Step
    public void createProfile(String name, String email, String gender, String status) throws Exception {

        CommonSteps.sendRequestWithJsonBody("POST", "/public/v1/users",
        new UserRequestBody().createUserProfile(name,email,gender,status));
    }

    @Step
    public void removeUserProfile() throws Exception {
        CommonSteps.sendRequest("DELETE", "/public/v1/users/" + Serenity.sessionVariableCalled("userId"));
    }

    @Step
    public void updateUserProfileName(String newName) throws Exception {

        CommonSteps.sendRequestWithJsonBody("PUT", "/public/v1/users/" + Serenity.sessionVariableCalled("userId") ,
                new UserRequestBody().updateUserProfile(newName));
    }

    @Step
    public void userCreatesAdditionalProfileWithAlreadyExistingEmail(String newName, String email, String newGender, String newStatus) throws Exception {

        CommonSteps.sendRequestWithJsonBody("POST", "/public/v1/users",
                new UserRequestBody().userCreatesAdditionalProfileWithAlreadyExistingEmail(newName,email,newGender,newStatus));
    }
}
