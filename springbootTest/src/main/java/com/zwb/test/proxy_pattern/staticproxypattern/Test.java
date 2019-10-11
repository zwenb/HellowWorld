package com.zwb.test.proxy_pattern.staticproxypattern;

public class Test {

    @org.junit.Test
    public void test(){
        ProxyFactory.getProxy().submit("我是原告，麻子欠钱跑路。");
        ProxyFactory.getProxy().defend();
    }
}
