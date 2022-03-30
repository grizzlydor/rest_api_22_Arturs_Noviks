package clickUpApi.stepDefinitions;

import clickUpApi.clients.ClickUpClient;
import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.domain.Task;
import clickUpApi.helpers.NameGenerator;
import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import static clickUpApi.clients.ClickUpClient.*;


public class ClickUpSteps {

    @Given("The TestSpace exists")
    public void getSpace(){
        Response resp = getTestSpace();
    }
    @When("I create a new folder called {string} and verify that the name is correct")
    public void createFolderAndVerify(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        Response resp = createFolder(obj); //this is the response we get, it returns a json object
        Folder defaultFolder = resp.as(Folder.class); //this takes the response as json obj and sends it to Folder class,
                                                        // which then looks through the obj to find values

        Assertions.assertThat(defaultFolder.getName()) //verifying that the name is correct
                .as("We assert that the name of the folder is the same as in the feature file, therefore is correct")
                .isEqualTo(name);

        TestCaseContext.setTestFolder(defaultFolder);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("Folder, called \"" + name + "\" was created.");
    }


    @Then("I create list called {string} in {string}")
    public void addList(String listName, String folderName){
        JSONObject obj = new JSONObject();
        obj.put("folder_id", TestCaseContext.getTestFolder().getId());
        obj.put("name", listName);
        Response resp = createList(obj);
        List defaultList = resp.as(List.class);

        TestCaseContext.setTestList(defaultList);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("List, called \"" + listName + "\" was created int the folder, called \"" + folderName + "\".");
    }

    @And("I verify that the list name is {string} and that it is added to the correct folder")
    public void verifyList(String listName){

        List testList = TestCaseContext.getTestList();

        Assertions.assertThat(testList.getName())
                .as("We assert that the list name is correct")
                .isEqualTo(listName);
        /*Assertions.assertThat(defaultList.getFolderId())
                .as("We assert that the list is in the correct folder")
                .isEqualTo(defaultFolder.getId());*/

        TestCaseContext.setTestList(testList);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("List name and location was verified.");
    }

    @Then("I create a task in {string}")
    public void addTask(String listName){
        JSONObject obj = new JSONObject();
        String taskName = NameGenerator.generate();
        obj.put("name", taskName);
        Response resp = createTask(obj);
        Task testTask = resp.as(Task.class);
        TestCaseContext.setTestTask(testTask);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("Task with a auto generated name was created.");
    }
    @And("I verify that the task name is correct")
    public void verifyTask(){
        Task testTask = TestCaseContext.getTestTask();
        List testList = TestCaseContext.getTestList();
        String taskName = TestCaseContext.getTestTask().getName();
        //By logic, the benchmark for correctness of a random, auto-generated name should be uniqueness, right?
        Assertions.assertThat(testTask.getName())
                .as("Checking if the task name is unique")
                .isNotIn(testList);
        Scenario scenario = TestCaseContext.getScenario();
        scenario.log("Task name \"" + taskName + "\" was verified to be unique, therefore correct.");
    }
    @Then("I remove the task from the list")
    public void removeTask(){
        //JSONObject obj = new JSONObject();
        Response resp = deleteTask();

        Task testTask = resp.as(Task.class);
        TestCaseContext.setTestTask(testTask);
    }
}
