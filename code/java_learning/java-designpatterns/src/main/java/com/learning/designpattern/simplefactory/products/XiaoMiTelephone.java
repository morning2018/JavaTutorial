package com.learning.designpattern.simplefactory.products;

import com.learning.designpattern.simplefactory.ITelephone;

/**
 *  具体的产品
 * @author morning
 * @date 2020/9/21 20:57
 * @since 0.0.1
 */
public class XiaoMiTelephone implements ITelephone {

    public void show() {
        System.out.println("小米手机");
    }
}
