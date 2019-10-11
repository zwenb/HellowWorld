package com.zwb.test.proxy_pattern.dynamicproxypattern;

import com.zwb.test.proxy_pattern.staticproxypattern.ILawSuit;

/**
 * 原告翠花也提起诉讼
 */
public class CuiHuaLawsuit implements ILawSuit {
    @Override
    public void submit(String proof) {
        System.out.println("作为老板麻子欠薪跑路本应该受到法律的制裁，诉讼详情： " + proof);
    }

    @Override
    public void defend() {
        System.out.println("铁证如山，天网恢恢疏而不漏，如实招来。");
    }
}
