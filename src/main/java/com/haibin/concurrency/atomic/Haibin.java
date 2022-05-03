package com.haibin.concurrency.atomic;

import lombok.Data;

@Data
public class Haibin {

    private Integer sequence;

    public Haibin(Integer seq){
        sequence = seq;
    }

}
