package com.haibin.design.strategy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRecommendReflectFactoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemRecommendReflectFactoryTest.class);
    @Autowired
    private GetPointAdvertisePageReflectFactory getItemRecommendStrategey;

    @Test
    public void  refectFactoryTest(){
        String path = "/itemrecommend.properties";
        GetPointAdvertisePageStrategey getPointAdvertisePageStrategey = getItemRecommendStrategey.getAdvertisePageStrategey(path,"pdp.item.advertise");
        if(getPointAdvertisePageStrategey != null){
            LOGGER.info("通过配置文件和反射机制，在运行时动态获取指定的执行类，测试成功");
            LOGGER.info(getPointAdvertisePageStrategey.getAdvertisePage());
        }
    }
}
