package com.haibin.restructure;

import org.springframework.stereotype.Service;

@Service
public class WeixinPay implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起微信支付===");
    }
}
