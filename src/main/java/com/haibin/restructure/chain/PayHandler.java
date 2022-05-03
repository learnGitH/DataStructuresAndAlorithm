package com.haibin.restructure.chain;

public abstract class PayHandler {

    protected PayHandler next;

    public PayHandler getNext() {
        return next;
    }

    public void setNext(PayHandler next) {
        this.next = next;
    }

    public abstract void pay(String pay);

}
