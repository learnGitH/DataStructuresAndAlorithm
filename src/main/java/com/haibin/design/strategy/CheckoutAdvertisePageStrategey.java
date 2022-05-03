package com.haibin.design.strategy;

import org.springframework.stereotype.Component;

@Component
public class CheckoutAdvertisePageStrategey implements  GetPointAdvertisePageStrategey{
    /**
     * 得到指定的结算页面
     *
     * @return
     */
    @Override
    public String getAdvertisePage() {
        return "checkout-advertise.jsp";
    }
}
