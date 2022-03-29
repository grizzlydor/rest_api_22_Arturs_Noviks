package clickUpApi.stepDefinitions;

import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.json.simple.JSONObject;

import static clickUpApi.clients.ClickUpClient.deleteFolder;

public class Hooks {
    @Before
    public void beforeEveryScenario(Scenario scenario){
        TestCaseContext.initialize(); //clears out all data before starting a new scenario
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO IS BEGINNING THE EXECUTION");
    }

    @After
    public void afterEveryScenario(){
        //deleteFolder();
        System.out.println("THE SCENARIO IS FINISHED");
    }
}
