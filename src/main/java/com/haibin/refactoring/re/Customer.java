package com.haibin.refactoring.re;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Set _orders = new HashSet();

    public Set friendOrders(){
        return _orders;
    }

    public void addOrder(Order arg){
        arg.setCustomer(this);
    }

}
