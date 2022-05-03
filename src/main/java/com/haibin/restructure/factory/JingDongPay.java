package com.haibin.restructure.factory;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JingDongPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("jingDongPay", this);
    }

    @Override
    public void pay() {
        System.out.println("===发起京东支付===");
    }
}
