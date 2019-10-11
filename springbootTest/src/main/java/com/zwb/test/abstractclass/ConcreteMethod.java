package com.zwb.test.abstractclass;

import org.junit.Test;

/**
 * 继承抽象类要么继续抽象下去，要么实现里面的方法
 */
public  class ConcreteMethod extends AbstractA {

    String s = "12323";

    @Override
    void method(String param) {

    }

    @Override
    void method2(String param) {

    }

    @Test
    public void test(){
        System.out.println(super.s);
    }
}
