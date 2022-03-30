package clickUpApi.clients;

import clickUpApi.domain.List;
import clickUpApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static clickUpApi.constants.ProjectConstants.API_TOKEN;
import static clickUpApi.constants.ProjectConstants.SPACE_ID;


public class ClickUpClient {

    public static Response getTestSpace(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/space/" + SPACE_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createFolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID +"/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createList(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getTestFolder().getId() +"/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    /*
    public static Response getList(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/list/" + TestCaseContext.getTestList().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    */

    public static Response deleteFolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/"+ TestCaseContext.getTestFolder().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();

    }
    public static Response createTask(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/"+ TestCaseContext.getTestList().getId() + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteTask(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTestTask().getId())
                .then().log().all()
                .statusCode(204)  //The task is deleted, however it returns a status code 204 and not the 200 as mentioned in the documentation
                .extract().response();
    }
}
