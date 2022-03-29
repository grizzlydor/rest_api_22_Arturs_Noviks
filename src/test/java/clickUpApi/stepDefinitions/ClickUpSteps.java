package clickUpApi.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import static clickUpApi.clients.ClickUpClient.createFolder;
import static clickUpApi.clients.ClickUpClient.getTestSpace;


public class ClickUpSteps {

    @Given("The TestSpace exists")
    public void getSpace(){
        Response resp = getTestSpace();
    }
    @When("I create a new folder called {string} and verify that the name is correct")
    public void clickUpCall(String name){
        JSONObject obj = new JSONObject();
        obj.put("name", "MyFolder");
        Response resp = createFolder(obj);

        Assertions.assertThat()



        /*System.out.println("Creating a folder called " + name);*/
    }


    @Then("I add a list")
    public void addList(){
        System.out.println("Adding a theoretical list");
    }
}
