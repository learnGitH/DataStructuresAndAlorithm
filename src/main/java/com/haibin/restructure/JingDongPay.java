package com.haibin.restructure;

import org.springframework.stereotype.Service;

@Service
public class JingDongPay implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起京东支付===");
    }
}