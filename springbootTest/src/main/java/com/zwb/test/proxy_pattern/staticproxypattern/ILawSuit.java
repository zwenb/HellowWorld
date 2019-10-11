package com.zwb.test.proxy_pattern.staticproxypattern;

/**
 * 王五要告麻子，王五找到了代理律师诸葛，王五的事全权交给诸葛负责。
 * 那么在向法院提起诉讼前就确定了原告，原告的代理律师，被告。
 * 即此种方式为静态代理
 */
public interface ILawSuit {
    //提起诉讼
    void submit(String proof);
    //法庭辩护
    void defend();
}
