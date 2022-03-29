package clickUpApi.stepDefinitions;

import clickUpApi.clients.ClickUpClient;
import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.helpers.TestCaseContext;
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
        obj.put("name", "MyFolder");
        Response resp = createFolder(obj); //this is the response we get, it returns a json object
        Folder defaultFolder = resp.as(Folder.class); //this takes the response as json obj and sends it to Folder class,
                                                        // which then looks through the obj to find values

        Assertions.assertThat(defaultFolder.getName()) //verifying that the name is correct
                .as("We assert that the name of the folder is correct")
                .isEqualTo("MyFolder");

        TestCaseContext.setTestFolder(defaultFolder);
        /*System.out.println("Creating a folder called " + name);*/
    }


    @Then("I create list in {string}")
    public void addList(String name){
        JSONObject obj = new JSONObject();
        obj.put("folder_id", "folderId");
        obj.put("name", "MyList");
        Response resp = createList(obj);
        //List defaultList = resp.as(List.class);

        /*System.out.println("Adding a theoretical list");*/
    }

    @And("I verify that the list name is {string} and that it is added to {string}")
    public void verifyList(String listName, String folderName ){
        Response resp = getList();
        List defaultList = resp.as(List.class);
        Assertions.assertThat(defaultList.getName())
                .as("We assert that the list name is correct")
                .isEqualTo(TestCaseContext.getTestList().getName());

        TestCaseContext.setTestList(defaultList);
        /*System.out.println("Verifying.....");*/
    }
}
