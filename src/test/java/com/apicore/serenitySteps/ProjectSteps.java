package com.apicore.serenitySteps;

import com.apicore.requestBodies.ProjectRequestBody;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.io.FileInputStream;
import java.util.Properties;

public class ProjectSteps {

    /**
     * Method to create a project
     */
    @Step
    public void createProject(String name) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/java/resources/data.properties"));

        CommonSteps.sendRequestWithJsonBody("POST", "/orgs/" + prop.getProperty("org") + "/projects", new ProjectRequestBody().getCreateProjectBody(name));
    }

    /**
     * Method to get a project
     */
    @Step
    public void getCreatedProject() throws Exception {
        CommonSteps.sendRequest("GET", "/projects/" + Serenity.sessionVariableCalled("projectId"));
    }

    /**
     * Method to remove a project
     */
    @Step
    public void removeCreatedProject() throws Exception {
        CommonSteps.sendRequest("DELETE", "/projects/" + Serenity.sessionVariableCalled("projectId"));
    }

    /**
     * Method to remove a project by id
     */
    @Step
    public void removeProjectById(String id) throws Exception {
        CommonSteps.sendRequest("DELETE", "/projects/" + id);
    }

    /**
     * Method to get a project by id
     */
    @Step
    public void getProjectById(String id) throws Exception {
        CommonSteps.sendRequest("GET", "/projects/" + id);
    }
}
