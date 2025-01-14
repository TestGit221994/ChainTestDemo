package com.demo.api.utils;

import com.demo.api.pojo.requestPojo.createUser.PojoCreateUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiUtils {

    public static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static String convertJavaObjectToString(Object object){
        String str="";
        try {
            str=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(PojoCreateUser.createPojoCreateUser());
        }catch (Exception ae){

        }return str;
    }


}
