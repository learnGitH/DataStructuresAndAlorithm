package com.haibin.restructure.template;

public interface IPay {
    boolean support(String code);
    void pay();
}
