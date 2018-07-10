package org.test.utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseApi {
    @Parameters("appUrl")
    @BeforeSuite
    public void setAppUrl(@Optional("http://jsonplaceholder.typicode.com") String appUrl){
        RestAssured.baseURI = appUrl;
    }
}
