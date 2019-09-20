package com.zwb.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MyTest extends Man {

    @Test
    public void test(){
        String s = ",abc_abc_NBA_CBA";
        System.out.println(s.indexOf("NBA"));

        String a = "";
        System.out.println(Integer.valueOf(a));
    }

    @Test
    public void test1(){
        String s = "  ";
        System.out.println(StringUtils.isBlank(s)); //true
        System.out.println(StringUtils.isEmpty(s)); //false

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("s", null);

    }

    @Test
    public void test2(){
        Ienum.enumclass blue = Ienum.enumclass.BLUE;
        System.out.println(blue.getRgb());

    }

    @Test
    public void test3(){
        MyTest myTest = new MyTest();
        myTest.setDescription("世界茶圣");
        Third<MyTest> third = Third.getThird();
        third.sys(myTest);
    }
}
