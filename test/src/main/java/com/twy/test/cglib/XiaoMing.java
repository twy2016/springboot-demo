package com.twy.test.cglib;

import com.twy.test.jdkProxy.ChanelFactory;
import com.twy.test.jdkProxy.WineFactory;

/**
 * @author gongpeng
 * @date 2020/8/31 10:49
 */
public class XiaoMing {

    public static void main(String[] args) {
        SellProxyFactory sellProxyFactory = new SellProxyFactory();
        ChanelFactory proxyInstance = (ChanelFactory) sellProxyFactory.getProxyInstance(new ChanelFactory());
        WineFactory wineFactory = (WineFactory) sellProxyFactory.getProxyInstance(new WineFactory());
        proxyInstance.sellPerfume(2000);
        wineFactory.sellWine(5000);
    }
}
