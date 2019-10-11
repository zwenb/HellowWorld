package com.zwb.test.abstractclass;

public abstract class AbstractA {
    String s = "qaz";
    abstract void method(String param);
    abstract void method2(String param);

    public void method3(){
        System.out.println("method3");
    }
}
