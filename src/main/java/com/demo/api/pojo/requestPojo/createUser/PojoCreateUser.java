package com.demo.api.pojo.requestPojo.createUser;

import com.demo.api.utils.RandomUtils;

public class PojoCreateUser {

    public PojoCreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    String name;
    String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public static PojoCreateUser createPojoCreateUser(){
        return new PojoCreateUser(RandomUtils.generateFirstName(),RandomUtils.generateFirstName());
    }



}

