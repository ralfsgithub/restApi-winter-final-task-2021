package com.apicore.requestBodies;

import com.apicore.util.JsonReader;

/**
 * This is class represents project requests bodies
 */
public class ProjectRequestBody {

    private static final String dir = System.getProperty("user.dir");

    public String getCreateProjectBody(String name) throws Exception {

        String requestBody = JsonReader.readJsonFileAsString(dir + "/src/test/resources/data/createProject.json");

        return requestBody.replace("$NAME", name);
    }
}