package com.haibin.restructure.template;

import org.springframework.stereotype.Service;

@Service
public class JingDongPay implements IPay {
    @Override
    public boolean support(String code) {
        return "jingdong".equals(code);
    }

    @Override
    public void pay() {
        System.out.println("===发起京东支付===");
    }
}
