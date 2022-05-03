package com.haibin.restructure.annotation;

import com.haibin.restructure.IPay;
import org.springframework.stereotype.Service;

@PayCode(value = "weixin", name = "微信支付")
@Service
public class WeixinPay2 implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起微信支付===");
    }
}
