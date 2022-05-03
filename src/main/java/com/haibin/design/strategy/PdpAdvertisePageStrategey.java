package com.haibin.design.strategy;

import org.springframework.stereotype.Component;

@Component
public class PdpAdvertisePageStrategey implements  GetPointAdvertisePageStrategey{
    /**
     * 得到指定的页面
     *
     * @return
     */
    @Override
    public String getAdvertisePage() {
        return "pdp-advertise.jsp";
    }
}
