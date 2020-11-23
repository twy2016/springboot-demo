package com.twy.test.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @author gongpeng
 * @date 2020/8/31 10:11
 */
public class XiaoMing {

    public static void main(String[] args) {
        ChanelFactory factory = new ChanelFactory();
        WineFactory wineFactory = new WineFactory();
        SellProxyFactory sellProxyFactory = new SellProxyFactory(factory);
        SellProxyFactory wineProxyFactory = new SellProxyFactory(wineFactory);
        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),sellProxyFactory);
        SellWine sellWine = (SellWine) Proxy.newProxyInstance(wineFactory.getClass().getClassLoader(),wineFactory.getClass().getInterfaces(),wineProxyFactory);
        sellPerfume.sellPerfume(2000);
        sellWine.sellWine(1500);
    }
}
