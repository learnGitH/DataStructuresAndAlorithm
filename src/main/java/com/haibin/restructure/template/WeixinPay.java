package com.haibin.restructure.template;

import org.springframework.stereotype.Service;

@Service
public class WeixinPay implements IPay {

    @Override
    public boolean support(String code) {
        return "weixin".equals(code);
    }

    @Override
    public void pay() {
        System.out.println("===发起微信支付===");
    }
}
