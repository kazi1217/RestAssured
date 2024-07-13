package com.megatechs.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Post {
    @Test
    public void PostMethod() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
       request.header("","");

        JSONObject jo = new JSONObject();
        jo.put("name", "Kazi");
        jo.put("job", "QA");

        request.body(jo.toJSONString());

        Response response = request.post("/api/users");

        int actualStatusCode = response.getStatusCode();
        System.out.println("Actual StatusCode " + actualStatusCode);
        Assert.assertEquals("201", "201");

       // String successCode =response.jsonPath().get(actualStatusCode);

        String bodyAsJason = response.body().jsonPath().prettify();
        System.out.println("bodyAsJason= " + bodyAsJason);


    }
}
