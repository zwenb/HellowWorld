package com.zwb.test.proxy_pattern.cgLib_dynamicproxypattern;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * cgLib对于final方法，无法进行代理。
 */
public class cgLibDynProxyLawyer implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("submit")){
            System.out.println("案件提交成功,证据如下："+ Arrays.asList(params));
        }
        Object result = methodProxy.invokeSuper(o, params);
        return result;
    }

}