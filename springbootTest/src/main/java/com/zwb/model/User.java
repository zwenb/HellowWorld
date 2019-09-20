package com.zwb.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private String skillId;

    public User(){

    }

    public User(String id, String name, String sex, int age, String address){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
}
