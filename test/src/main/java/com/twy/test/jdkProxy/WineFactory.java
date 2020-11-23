package com.twy.test.jdkProxy;

/**
 * @author gongpeng
 * @date 2020/8/31 10:11
 */
public class WineFactory implements SellWine {
    @Override
    public void sellWine(double price) {
        System.out.println("成功购买法国红酒，价格是：" + price + "元");
    }
}

