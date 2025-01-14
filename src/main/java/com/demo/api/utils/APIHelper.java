package com.demo.api.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

public class APIHelper {

    private static final Logger logger = getLogger(APIHelper.class);
    public static Response apiResponse = null;

    public static Response executeAndGetResponse(String fullURL,String methodType,Map<String,String> apiHeaders,String jsonStringBody){
        return executeAndGetResponse(fullURL,methodType,null,apiHeaders,jsonStringBody,true);
    }

    public static Response executeAndGetResponse(String fullURL, String methodType, Map<String, String> apiParameters, Map<String, String> apiHeaders, String jsonBody, Boolean parameterIncludedBody) {
        Boolean disableCharSetFlag = false;
        Integer responseCode;
        //remove the query params from full url
        String[] cmd = fullURL.split("\\?");
        String requestURL = cmd[0];

        // Prepare Request
        RequestSpecification requestSpecification = RestAssured.given();

        if (apiHeaders != null && apiHeaders.size() > 0) {
            // Set request headers
            for (Map.Entry<String, String> headers : apiHeaders.entrySet()) {
                requestSpecification.header(headers.getKey(), headers.getValue());
                if (headers.getValue().contains("application/fhir+json") || headers.getValue().contains("application/fhir+xml")) {
                    disableCharSetFlag = true;
                }
            }
        }

        if (jsonBody != null && (jsonBody.endsWith(".xlsx") || jsonBody.endsWith(".xls"))) {
            requestSpecification = requestSpecification.multiPart("file_storage", new File(jsonBody));
        } else if (jsonBody != null) {
            requestSpecification = requestSpecification.body(jsonBody);
        }

        if (apiParameters != null) {
            if (apiParameters != null && apiParameters.size() > 0) {
                for (Map.Entry<String, String> parameters : apiParameters.entrySet()) {
                    requestSpecification = requestSpecification.queryParam(parameters.getKey(), parameters.getValue());
                }
            }
        } else if (cmd.length > 1) {
            String parameters[] = cmd[1].split("&");
            for (int i = 0; i < parameters.length; i++) {
                requestSpecification = requestSpecification.queryParam(parameters[i].split("=")[0], parameters[i].split("=")[1]);
            }
        }


        // Logs the request details
        if (PropertyUtils.getProperty("logsDetailsMode") != null && Boolean.valueOf(PropertyUtils.getProperty("logsDetailsMode"))) {
            requestSpecification = requestSpecification.log().all();
        }



        //Execute API
        requestSpecification=requestSpecification.when();

        Response response=null;
        switch (methodType.toLowerCase()){

            case "get":
                response=requestSpecification.get(requestURL);
                break;
            case "post":
                response=requestSpecification.post(requestURL);
                break;
            case "delete":
                response=requestSpecification.delete(requestURL);
                break;
            case "put":
                response=requestSpecification.put(requestURL);
                break;
            case "patch":
                response=requestSpecification.patch(requestURL);
                break;
        }

        if(PropertyUtils.getProperty("logsDetailsMode") != null && PropertyUtils.getProperty("logsDetailsMode").equals("true")){
            response=response.then().log().all().extract().response();

            logger.info(" API Response for : " +requestURL+" :- "+response.asString());
            logger.info(" API Response Cookie : " +response.getCookies());
            logger.info(" API Response Time : "+response.getTime());
            logger.info(" API Headers : "+response.getHeaders());
        }else {
            logger.info(" Request URL : " +requestURL);
            logger.info(" Request Headers : " +apiHeaders);

            if(parameterIncludedBody){
                logger.info(" Request Body is : " +jsonBody);
            } if(cmd.length>1){
                logger.info(" Request Parameters : " + Arrays.toString(cmd[1].split("&")));
            }if(response.getStatusCode() !=200 && response.getStatusCode() !=201){
                logger.info(" API Response for  : " +requestURL + " :- "+response.asString());
            }
        }


        logger.info(" Response code : " +response.getStatusCode());
        //Browser.wait(testConfig,5);
        return response;
    }

    public static String createJsonParameters(HashMap<String,String> parameters){

        JSONObject jasonPostParameter=new JSONObject();
        for(Map.Entry<String,String> entry : parameters.entrySet()){
            jasonPostParameter.put(entry.getKey(),entry.getValue());
        }return jasonPostParameter.toString();
    }

    public static JSONObject parseJSONFileInJSONObject(String fileLocationURL){
        JSONObject jsonObject=null;
        InputStream inputStream;
        try{
            inputStream=new FileInputStream(fileLocationURL);
            //JsonToken jsonToken=new JsonToken(inputStream);
        }catch (Exception ae){

        }return jsonObject;
    }

    public static Response executeAndGetResponse(String fullURL,String methodType,Map<String,String> apiParameters,Map<String,String> apiHeaders){
        return executeAndGetResponse(fullURL,methodType,apiParameters,apiHeaders,null,false);
    }

    public static Response executeAndGetResponse(String fullURL,String methodType,Map<String,String> apiHeaders,Map<String,String> mapKeyParameter,String apiInBody){
        return executeAndGetResponse(fullURL,methodType,mapKeyParameter,apiHeaders,apiInBody,true);
    }

    public static String createJsonParameter(Map<String,String> parameters){
        LinkedHashMap<String,String> hasMap = new LinkedHashMap<String,String>(parameters);
        org.json.JSONObject jsonPostParameters = new org.json.JSONObject(hasMap);

        try{
            Field changeMap = jsonPostParameters.getClass().getDeclaredField("map");
            changeMap.setAccessible(true);
            changeMap.set(jsonPostParameters,new LinkedHashMap<>());
            changeMap.setAccessible(false);
        }catch (IllegalAccessException | NoSuchFieldException ae){
            logger.info("");
        }

        for(Map.Entry<String,String> entry : parameters.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            try{
                jsonPostParameters.put(key,value);
            }catch (JSONException ae){
                logger.info("");
            }
        }return jsonPostParameters.toString();
    }

    public static Response executeAndGetResponseForMultiPartFormParams(String fullURL,String methodType,Map<String,Object> multiPartParams,Map<String,String> apiHeaders){
        int responseCode;
        String requestURL = fullURL;
        RequestSpecification requestSpecification = RestAssured.given();

        if(apiHeaders != null && apiHeaders.size() > 0){
            requestSpecification =requestSpecification.headers(apiHeaders);
        }
        for(Map.Entry<String,Object> entry : multiPartParams.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            requestSpecification = requestSpecification.multiPart(key,value);
        }

        if(PropertyUtils.getProperty("logsDetailsMode") != null && PropertyUtils.getProperty("logsDetailsMode").equals("true")){
            requestSpecification = requestSpecification.log().all();
        }

        requestSpecification = requestSpecification.when();

        Response response = null;
        switch (methodType.toLowerCase()){
            case "post":
                response = requestSpecification.post(requestURL);
                break;
            case "put":
                response = requestSpecification.put(requestURL);
                break;
            case "patch":
                response = requestSpecification.patch(requestURL);
                break;
        }

        if(PropertyUtils.getProperty("logsDetailsMode") != null && PropertyUtils.getProperty("logsDetailsMode").equals("true")){
            response = response.then().log().all().extract().response();

            logger.info(" API Response for " +requestURL+" : -" +response.asString());
            logger.info(" Response Cookie " +response.getCookies());
            logger.info(" Response Time " +response.getTime());
            logger.info(" Response Headers " +response.getHeaders());


        }else {
            logger.info(" Request URL " +requestURL);
            logger.info(" Response Headers " +apiHeaders);
            responseCode = response.getStatusCode();
            if(responseCode !=200 && responseCode !=201){
                logger.info(" API response for " +requestURL+" :- " +response.asString());
            }
        }
        logger.info(" Response code : " +response.getStatusCode());
        WaitUtils.pause(90);
        return response;
    }
}
