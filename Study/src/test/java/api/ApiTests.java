package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author merve.sozen
 */
public class ApiTests {
    static Response response =null;
    //API that does 4 operations (addition, subtraction, multiplication, and, division) and calculates the sum of numbers from 1 to n.

    @Test
    public void loginApiUser(){
        Response response = RestAssured.given().auth().preemptive().oauth2("username").get(EndPoints.base_url+EndPoints.login_url);
        int statusCode= response.getStatusCode();
        given().when().post(EndPoints.base_url+EndPoints.login_url).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        System.out.println(response.getHeaders());
    }

    @Test
    public void calculationExample1 () {
        RequestSpecification httpRequest = (RequestSpecification) given();
        response =(Response) httpRequest.header("Authorization", "Bearer " , "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when().post(EndPoints.base_url+EndPoints.sumExample1).then().extract().response();
        int statusCode= response.getStatusCode();
        given().when().post(EndPoints.base_url+EndPoints.sumExample1).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        String actualResult= response.jsonPath().get("result").toString();
        Assert.assertEquals(EndPoints.base_url+EndPoints.sumExampleResult1, actualResult);
    }
    @Test
    public void calculationExample2 () {
        RequestSpecification httpRequest = (RequestSpecification) given();
        response =(Response) httpRequest.header("Authorization", "Bearer " , "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when().post(EndPoints.base_url+EndPoints.multiExample2).then().extract().response();
        int statusCode= response.getStatusCode();
        given().when().post(EndPoints.base_url+EndPoints.multiExample2).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        String actualResult= response.jsonPath().get("result").toString();
        Assert.assertEquals(EndPoints.base_url+EndPoints.multiExampleResult2, actualResult);
    }
    @Test
    public void calculationExample3 () {
        RequestSpecification httpRequest = (RequestSpecification) given();
        response =(Response) httpRequest.header("Authorization", "Bearer " , "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when().post(EndPoints.base_url+EndPoints.divisionExample3).then().extract().response();
        int statusCode= response.getStatusCode();
        given().when().post(EndPoints.base_url+EndPoints.divisionExample3).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        String actualResult= response.jsonPath().get("result").toString();
        Assert.assertEquals(EndPoints.base_url+EndPoints.divisionExampleResult3, actualResult);
    }

    @Test
    public void calculationSumExample1 () {
        RequestSpecification httpRequest = (RequestSpecification) given();
        response =(Response) httpRequest.header("Authorization", "Bearer " , "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when().get(EndPoints.base_url+EndPoints.getSumExample1).then().extract().response();
        int statusCode= response.getStatusCode();
        given().when().get(EndPoints.base_url+EndPoints.getSumExample1).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        String actualResult= response.jsonPath().get("result").toString();
        Assert.assertEquals(EndPoints.base_url+EndPoints.getSumExampleResult1, actualResult);
    }

    @Test
    public void calculationSumExample2 () {
        RequestSpecification httpRequest = (RequestSpecification) given();
        response =(Response) httpRequest.header("Authorization", "Bearer " , "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when().get(EndPoints.base_url+EndPoints.getSumExample2).then().extract().response();
        int statusCode= response.getStatusCode();
        given().when().get(EndPoints.base_url+EndPoints.getSumExample2).then().assertThat().statusCode(200);
        System.out.println("The response status is "+statusCode);
        String actualResult= response.jsonPath().get("result").toString();
        Assert.assertEquals(EndPoints.base_url+EndPoints.getSumExampleResult2, actualResult);
    }

}
