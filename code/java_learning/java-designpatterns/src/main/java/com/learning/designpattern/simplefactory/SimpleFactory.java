package com.learning.designpattern.simplefactory;

import com.learning.designpattern.simplefactory.constant.Const;
import com.learning.designpattern.simplefactory.products.HuaWeiTelephone;
import com.learning.designpattern.simplefactory.products.VivoTelephone;
import com.learning.designpattern.simplefactory.products.XiaoMiTelephone;

/**
 *  简单工厂
 * @author morning
 * @date 2020/9/21 21:03
 * @since 0.0.1
 */
public class SimpleFactory {

    /**
     *  生产产品
     * @author morning
     * @date 2020/9/21 21:04
     * @since 0.0.1
     */
    public static ITelephone productTelephone(int kind) {
        switch (kind) {
            case Const.HUAWEI:
                return  new HuaWeiTelephone();
            case Const.XIAOMI:
                return new XiaoMiTelephone();
            case Const.VIVO:
                return new VivoTelephone();
            default:
                return null;
        }
    }
}
