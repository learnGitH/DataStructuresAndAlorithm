package com.haibin.design.strategy;

import org.springframework.stereotype.Component;

@Component
public class PlpAdvertisePageStrategey implements GetPointAdvertisePageStrategey{
    /**
     * 得到指定的plp广告页面
     *
     * @return
     */
    @Override
    public String getAdvertisePage() {
        return "plp-advertise.jsp";
    }
}
