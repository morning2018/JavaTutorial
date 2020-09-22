package com.learning.designpattern.creational.simplefactory;

import com.learning.designpattern.creational.simplefactory.constant.Const;

/**
 *  simple factory client
 * @author morning
 * @date 2020/9/21 21:05
 * @since 0.0.1
 */
public class Client {

    public static void main(String[] args) {
        ITelephone telephone = SimpleFactory.productTelephone(Const.HUAWEI);
        telephone.show();
        telephone = SimpleFactory.productTelephone(Const.XIAOMI);
        telephone.show();
        telephone = SimpleFactory.productTelephone(Const.VIVO);
        telephone.show();
    }
}
