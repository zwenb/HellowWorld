package com.zwb.test.proxy_pattern.staticproxypattern;

public class ProxyFactory {
    public static ILawSuit getProxy(){
        ILawSuit wangWuLawsuit = new WangWuLawsuit();
        ILawSuit proxyLawyer = new ProxyLawyer(wangWuLawsuit);
        return proxyLawyer;
    }
}
