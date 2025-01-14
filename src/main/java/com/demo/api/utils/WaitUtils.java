package com.demo.api.utils;




public class WaitUtils {



    public static void pause(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}