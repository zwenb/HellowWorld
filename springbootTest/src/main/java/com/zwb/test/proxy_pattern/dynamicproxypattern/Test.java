package com.zwb.test.proxy_pattern.dynamicproxypattern;

import com.zwb.test.proxy_pattern.staticproxypattern.ILawSuit;

public class Test {
    @org.junit.Test
    public void test(){
        ILawSuit proxy= (ILawSuit) ProxyFactory.getDynProxy(new CuiHuaLawsuit());
        //系统就会将此方法分发给invoke()
        proxy.submit("工资流水在此");
        proxy.defend();
    }
}
