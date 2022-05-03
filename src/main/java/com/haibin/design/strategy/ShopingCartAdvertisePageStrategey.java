package com.haibin.design.strategy;

import org.springframework.stereotype.Component;

@Component
public class ShopingCartAdvertisePageStrategey implements  GetPointAdvertisePageStrategey{
    /**
     * 得到指定的购物车页面
     *
     * @return
     */
    @Override
    public String getAdvertisePage() {
        return "shoppingcart-advertise.jsp";
    }
}
