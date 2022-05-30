package in.reqres.reqresinfo;
/* 
 Created by Kalpesh Patel
 */

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresGetTest extends TestBase {

    @Test
    public void getAllUsers() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);

        System.out.println("--------------- Printing Response -------------------------");
        int page = response.then().extract().path("page");
        System.out.println("1. Page          :" + page);

        int per_page = response.then().extract().path("per_page");
        System.out.println("2. Per Page      :" + per_page);

        int id = response.then().extract().path("data[1].id");
        System.out.println("3. ID            :" + id);

        String first_name = response.then().extract().path("data[3].first_name");
        System.out.println("4. First Name    :" + first_name);

        List<?> listOfData = response.then().extract().path("data");
        System.out.println("5. List of Data  :" + listOfData.size());

        String avatar = response.then().extract().path("data[5].avatar");
        System.out.println("6. Avatar        :" + avatar);

        String supportUrl = response.then().extract().path("support.url");
        System.out.println("7. Support URL   :" + supportUrl);

        String supportText = response.then().extract().path("support.text");
        System.out.println("8. Support Text  :" + supportText);
        System.out.println("--------------- END of Printing Response ------------------");
        response.prettyPrint();

    }

    @Test
    public void getSingleUser() {
        Response response = given()
                .pathParam("id", 2)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        System.out.println("--------------- Printing Response -------------------------");
        response.prettyPrint();
        System.out.println("--------------- END of Printing Response ------------------");

    }

}
