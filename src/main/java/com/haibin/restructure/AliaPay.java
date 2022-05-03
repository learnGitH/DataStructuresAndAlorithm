package com.haibin.restructure;

import org.springframework.stereotype.Service;

@Service
public class AliaPay implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起支付宝支付===");
    }
}
