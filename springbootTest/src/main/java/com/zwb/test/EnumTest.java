package com.zwb.test;

public enum EnumTest {
    FEMALE("女", 1),
    MALE("男", 2);


    public String name;
    public int value;

    EnumTest(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Test{

    public static void main(String[] args) {
        System.out.println(EnumTest.FEMALE.value);
    }

}
