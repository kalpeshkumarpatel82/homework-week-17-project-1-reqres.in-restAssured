package in.reqres.reqresinfo;
/* 
 Created by Kalpesh Patel
 */

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresDeleteTest extends TestBase {
    @Test
    public void deleteUser(){
        Response response = given()
                .pathParam("id",137)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
