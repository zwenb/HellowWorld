package com.zwb.test.proxy_pattern.staticproxypattern;

public class ProxyLawyer implements ILawSuit {

    //持有要代理的那个对象
    private ILawSuit plaintiff;

    public ProxyLawyer(ILawSuit plaintiff){
        this.plaintiff = plaintiff;
    }

    @Override
    public void submit(String proof) {
        //此处可以做保护代理对象处理
        plaintiff.submit(proof);
    }

    @Override
    public void defend() {
        plaintiff.defend();
    }
}
