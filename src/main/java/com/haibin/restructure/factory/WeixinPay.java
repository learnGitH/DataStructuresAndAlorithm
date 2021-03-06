package com.haibin.restructure.factory;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class WeixinPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("weixinPay", this);
    }

    @Override
    public void pay() {
        System.out.println("===发起微信支付===");
    }
}
