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
    public static Response getList(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(obj)
                .when()
                .get("https://api.clickup.com/api/v2/list/" + TestCaseContext.getTestList().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
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
}
