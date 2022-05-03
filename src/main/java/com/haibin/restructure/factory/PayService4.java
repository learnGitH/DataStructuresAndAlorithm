package com.haibin.restructure.factory;

import org.springframework.stereotype.Service;

@Service
public class PayService4 {

    public void toPay(String code) {
        PayStrategyFactory.get(code).pay();
    }
}
