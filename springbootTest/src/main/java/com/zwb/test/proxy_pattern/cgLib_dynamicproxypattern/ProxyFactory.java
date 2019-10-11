package com.zwb.test.proxy_pattern.cgLib_dynamicproxypattern;

import org.springframework.cglib.proxy.Enhancer;

public class ProxyFactory {
    public static Object getGcLibDynProxy(Object target){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new cgLibDynProxyLawyer());
        Object targetProxy= enhancer.create();
        return targetProxy;
    }
}