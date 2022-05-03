package com.haibin.design.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
    private static Map<String, Properties> cache = new HashMap<>();

    /**
     *
     * @param configFileName 配置文件名
     * @param key  配置文件中的 key=value  中的key
     * @return
     */
    public static String get(String configFileName,String key){
        return getProperties(configFileName).getProperty(key);
    }

    public static Properties getProperties(String configFileName) {
        if (cache.get(configFileName) != null) {
            return cache.get(configFileName);
        }
        InputStream inputStream = PropertyUtil.class.getResourceAsStream(configFileName);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cache.put(configFileName,properties);
        return  properties;
    }

}
