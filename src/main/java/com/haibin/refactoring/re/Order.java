package com.haibin.refactoring.re;

public class Order {
    Customer _customer;

    public Customer getCustomer() {
        return _customer;
    }

    public void setCustomer(Customer arg) {
        if (_customer != null){
            _customer.friendOrders().remove(this);
        }
        _customer = arg;
        if (_customer != null){
            _customer.friendOrders().add(this);
        }

    }

}
