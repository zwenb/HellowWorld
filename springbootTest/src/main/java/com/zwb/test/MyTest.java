package com.zwb.test;

import com.zwb.test.chain_pattern.ConcreteHandler1;
import com.zwb.test.chain_pattern.ConcreteHandler2;
import com.zwb.test.chain_pattern.ConcreteHandler3;
import com.zwb.test.chain_pattern.Handler;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MyTest extends Man {

    public static final String S = "hello world"; //常量池中

    @Test
    public void test(){
        String s = "abc_abc_NBA_CBA";
        /*System.out.println(s.indexOf("NBA"));
        String a = "";
        System.out.println(Integer.valueOf(a));*/

        StringBuffer sb = new StringBuffer(s);
        System.out.println(sb.reverse());
        StringBuilder stringBuilder = new StringBuilder();
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
    
    @Test
    public void test4(){
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        //提交请求
        handler1.handleRequest("two");
        handler2.handleRequest("three");

    }
}
