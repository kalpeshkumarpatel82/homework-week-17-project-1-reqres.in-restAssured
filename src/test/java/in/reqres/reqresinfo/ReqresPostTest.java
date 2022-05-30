package in.reqres.reqresinfo;
/* 
 Created by Kalpesh Patel
 */

import in.reqres.model.ReqresPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresPostTest extends TestBase {

    @Test
    public void createUser(){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setJob("API Tester");
        reqresPojo.setName("Bob Peter");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqresPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void loginSuccessfulUser(){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail("eve.holt@reqres.in");
        reqresPojo.setPassword("cityslicka");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqresPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
