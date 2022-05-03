package com.haibin.restructure.annotation;

import com.haibin.restructure.IPay;
import org.springframework.stereotype.Service;

@PayCode(value = "alia", name = "支付宝支付")
@Service
public class AliaPay2 implements IPay {
    @Override
    public void pay() {
        System.out.println("===发起支付宝支付===");
    }
}
