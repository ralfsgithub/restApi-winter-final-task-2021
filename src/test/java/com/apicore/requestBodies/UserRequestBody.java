package com.apicore.requestBodies;

import com.apicore.util.JsonReader;

public class UserRequestBody {

    private static final String dir = System.getProperty("user.dir");


    public String createUserProfile(String name, String email, String gender, String status) throws Exception {

        String requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/createUser.json");

        return requestBody.replace("$NAME", name).replace("$EMAIL", email).replace("$GENDER", gender).replace("$STATUS", status);
    }

    public String updateUserProfile(String newName) throws Exception {

        String requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/updateUserName.json");

            return requestBody.replace("$NAME", newName);
    }

    public String userCreatesAdditionalProfileWithAlreadyExistingEmail(String newName, String email, String newGender, String newStatus) throws Exception {

        String requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/createUser.json");

        return requestBody.replace("$NAME", newName).replace("$EMAIL", email).replace("$GENDER", newGender).replace("$STATUS", newStatus);
    }
}
