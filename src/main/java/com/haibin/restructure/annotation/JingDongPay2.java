package com.haibin.restructure.annotation;

import com.haibin.restructure.IPay;
import org.springframework.stereotype.Service;

@PayCode(value = "jingdong", name = "京东支付")
@Service
public class JingDongPay2 implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起京东支付===");
    }
}