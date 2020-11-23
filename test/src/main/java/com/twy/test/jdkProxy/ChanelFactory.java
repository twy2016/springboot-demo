package com.twy.test.jdkProxy;

/**
 * @author gongpeng
 * @date 2020/8/31 10:11
 */
public class ChanelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("成功购买香奈儿品牌的香水，价格是：" + price + "元");
    }
}

