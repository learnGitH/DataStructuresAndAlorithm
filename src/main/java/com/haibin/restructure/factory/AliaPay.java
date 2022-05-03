package com.haibin.restructure.factory;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AliaPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("aliaPay", this);
    }


    @Override
    public void pay() {
        System.out.println("===发起支付宝支付===");
    }

}
