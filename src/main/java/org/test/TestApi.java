package org.test;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.test.utils.TestBaseApi;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;


public class TestApi extends TestBaseApi {
    @Test
    public void testStatusCodeIsCorrect(){
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/users")
        .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testNumberOfUsersIsCorrect(){
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/users")
        .then()
            .assertThat()
            .body("size()", is(10));
    }

    @Test
    public void testResponseBodyIsCorrectForUser1(){
        String expectedTitle = "reprehenderit";
        String expectedBody = "consequuntur";
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/posts/1")
        .then()
            .assertThat()
            .body("title", containsString(expectedTitle), "body", containsString(expectedBody));
    }

    @Test
    public void testAddingNewPostWorks(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "test");
        map.put("body", "test body");
        map.put("userId", "1");
        given()
            .contentType(ContentType.JSON)
            .body(map)
        .when()
            .post("/posts")
        .then()
            .statusCode(HttpStatus.SC_CREATED);
    }
}
