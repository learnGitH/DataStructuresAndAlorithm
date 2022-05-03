package com.haibin.restructure.template;

import org.springframework.stereotype.Service;

@Service
public class AliaPay implements IPay {
    @Override
    public boolean support(String code) {
        return "alia".equals(code);
    }

    @Override
    public void pay() {
        System.out.println("===发起支付宝支付===");
    }
}
