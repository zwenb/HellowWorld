package com.zwb.test;

public class Third<T extends Man> {

    private static Third third;

    static {
        third = new Third();
    }

    //该处的私有构造方法是为了不让该类外部直接去实例化该类
    private Third(){

    }

    public static Third getThird() {
        return third;
    }

    public void sys(T t){
        System.out.println(t.getDescription());
    }

}
