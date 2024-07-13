package com.megatechs.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class APITesting_Get {


            @Test
            public void GetMethodrrr(){
                RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
                //https://jsonplaceholder.typicode.com/posts

                RequestSpecification req = RestAssured.given();
                Response response= req.request(Method.GET,"posts/1");
                String getStatusLine = response.getStatusLine();
                System.out.println("getStatusLine "+getStatusLine);
                int getStatusCode = response.getStatusCode();
                System.out.println("getStatusCode"+getStatusCode);
                Assert.assertEquals(getStatusCode,200);

                System.out.println("============================================");

                Headers headers=response.headers();
               // System.out.println("headers"+headers);
                System.out.println("================================");

                List headerList= headers.asList();
                System.out.println("headerList"+headerList);

                System.out.println("==========================");
                int headersize =headers.asList().size();
                System.out.println("headersize= "+headersize);
                System.out.println(headers.asList().size());
                System.out.println("============================================");
                String bodyasstring = response.body().asString();

                System.out.println("Bodys"+bodyasstring);

                bodyasstring.contains("title");

                System.out.println("============================================");

                String bodyas_json = response.body().jsonPath().prettify();
                System.out.println("bodyas_json = "+bodyas_json);
                String bodyas_json_title = response.body().jsonPath().get("title");
                System.out.println("Bodyas_json_title = "+bodyas_json_title);
                String bodyas_json_id = response.body().jsonPath().get("id");
                System.out.println("Bodyas_json_id = "+bodyas_json_id);

                String bodyas_json_userId = response.body().jsonPath().get("userId");
                System.out.println("Bodyas_json_userId = "+bodyas_json_userId);


            }
        }


