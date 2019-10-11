package com.zwb.test.proxy_pattern.cgLib_dynamicproxypattern;

public class Test {
    @org.junit.Test
    public void test(){
        Frank cProxy= (Frank) ProxyFactory.getGcLibDynProxy(new Frank());
        cProxy.submit("工资流水在此");
        cProxy.defend();
    }
}
