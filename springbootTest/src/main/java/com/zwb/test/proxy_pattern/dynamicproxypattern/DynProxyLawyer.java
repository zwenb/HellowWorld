package com.zwb.test.proxy_pattern.dynamicproxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 构建一个动态代理类
 */
public class DynProxyLawyer implements InvocationHandler {

    //持有被代理的对象
    private Object target;

    public DynProxyLawyer(Object target){
        this.target = target;
    }


    /**
     * jdk动态代理方法
     *
     * @param proxy 代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args 代表当前执行方法传入的实参
     * @return 表示当前执行方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理的方法名
        System.out.println("案件进展："+method.getName());
        Object result = method.invoke(target,args);
        return result;
    }
}
