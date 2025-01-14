package com.demo.api.stepDefinition;

import com.demo.api.pojo.requestPojo.createUser.PojoCreateUser;
import com.demo.api.utils.APIHelper;
import com.demo.api.utils.ApiUtils;
import com.demo.api.utils.FileUtils;
import com.demo.api.utils.PropertyUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.python.antlr.ast.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DemoStepDefinition {


    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    @When("I hit the {string} method of create customer api with {string} end point")
    public void iHitTheMethodOfCreateCustomerApiWithEndPoint(String requestMethod, String endPoint) {

        String fullURL = PropertyUtils.getProperty("ApplicationURL") + endPoint;

       APIHelper.apiResponse= APIHelper.executeAndGetResponse(fullURL,requestMethod,null,null,null,true);

    }

    @Then("Verify the status code is {string}")
    public void verifyTheStatusCodeIs(String arg0) {
        Assert.assertEquals(200,APIHelper.apiResponse.getStatusCode());
    }

    @Then("Validate employee details in response")
    public void validateEmployeeDetailsInResponse() {

    }

    @Given("I want to create test case {string}")
    public void iWantToCreateTestCase(String testCaseName) {
        logger.info(" Service Name : " +testCaseName);
    }



    @Then("Validate user details in POST API response")
    public void validateUserDetailsInPOSTAPIResponse() {
       System.out.println(" json Body : " +APIHelper.apiResponse.getBody().prettyPrint());

    }

    @Then("Validate user details in GET API response")
    public void validateUserDetailsInGETAPIResponse() {
        
    }

    @Then("Validate user details in PUT API response")
    public void validateUserDetailsInPUTAPIResponse() {
        
    }

    @Then("Validate user details in DELETE API response")
    public void validateUserDetailsInDELETEAPIResponse() {
        
    }

    @When("I hit the {string} method of POST USER API with {string} end point")
    public void iHitTheMethodOfPOSTUSERAPIWithEndPoint(String requestMethod, String endPoint) throws JsonProcessingException {

        String fullURL = PropertyUtils.getProperty("ApplicationURL") + endPoint;

        String createUserJson = ApiUtils.convertJavaObjectToString(PojoCreateUser.createPojoCreateUser());

        Map<String, String>headers = new HashMap<>();
        headers.put("Content-type","application/json");

        APIHelper.apiResponse= APIHelper.executeAndGetResponse(fullURL,requestMethod,null,headers,null,true);

    }

    @When("I hit the {string} method of GET USER API with {string} end point")
    public void iHitTheMethodOfGETUSERAPIWithEndPoint(String requestMethod, String endPoint) {
        
    }

    @When("I hit the {string} method of PUT USER API with {string} end point")
    public void iHitTheMethodOfPUTUSERAPIWithEndPoint(String requestMethod, String endPoint) {
        String fullURL = PropertyUtils.getProperty("ApplicationURL") + endPoint;

        String createUserJson = ApiUtils.convertJavaObjectToString(PojoCreateUser.createPojoCreateUser());

        Map<String, String>headers = new HashMap<>();
        headers.put("Content-type","application/json");

        APIHelper.apiResponse= APIHelper.executeAndGetResponse(fullURL,requestMethod,null,headers,null,true);

    }

    @When("I hit the {string} method of DELETE USER API with {string} end point")
    public void iHitTheMethodOfDELETEUSERAPIWithEndPoint(String requestMethod, String endPoint) {
        String fullURL = PropertyUtils.getProperty("ApplicationURL") + endPoint;

        APIHelper.apiResponse= APIHelper.executeAndGetResponse(fullURL,requestMethod,null,null,null,true);


    }

    @Then("Validate the status code of POST API is {string}")
    public void validateTheStatusCodeOfPOSTAPIIs(String statusCode) {
        Assert.assertEquals(Integer.valueOf(statusCode),Integer.valueOf(APIHelper.apiResponse.getStatusCode()));
    }

    @Then("Validate the status code of GET API is {string}")
    public void validateTheStatusCodeOfGETAPIIs(String arg0) {
    }

    @Then("Validate the status code is {string}")
    public void validateTheStatusCodeIs(String statusCode) {
        Assert.assertEquals(Integer.valueOf(statusCode),Integer.valueOf(APIHelper.apiResponse.getStatusCode()));
    }
}
