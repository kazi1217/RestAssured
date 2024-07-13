package com.megatechs.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_GetPractice {
    @Test
    public void getrequestPractice() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification r = RestAssured.given();
        Response response = r.request(Method.GET, "/api/users?page=2");
        //https://reqres.in/api/users?page=2

        System.out.println("===================getStatusCode======================");
        int ActualStatusCode = response.getStatusCode();
        // System.out.println("My StatusCode = " + response.getStatusCode());
        System.out.println("My StatusCode = " + ActualStatusCode);
        Assert.assertEquals(ActualStatusCode, 200);

        System.out.println("==================getStatusLine======================");
        String getStatusLine = response.getStatusLine();
        System.out.println("My StatusLine =" + getStatusLine);
        Assert.assertEquals(getStatusLine, "HTTP/1.1 200 OK");

        System.out.println("=============headers=====================");
        Headers headers = response.headers();
        System.out.println("Headers" + headers);


        System.out.println("=============header=====================");

        String server = response.header("Server");
        System.out.println("server= " + server);
        Assert.assertEquals(server, "cloudflare");

        System.out.println("=============Body:validate as a String=====================");


        ResponseBody body = response.body();
        String bodyasstring = response.body().asString();
        System.out.println("Bodys" + bodyasstring);


        System.out.println("=============Body:validate as a JsonPath=====================");

        ResponseBody body2 = response.body();
        String bodyasJson = response.body().jsonPath().prettify();
        System.out.println("bodyas_json = " + bodyasJson);

    }
}
