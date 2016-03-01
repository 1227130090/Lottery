package com.example.test.lottery.util;

import com.example.test.lottery.engine.UserEngine;

import java.io.IOException;
import java.util.Properties;

/**
 * 工厂类
 *
 */
public class BeanFactory {
    //依据配置文件加载实例

    private static Properties properties;

    static {
        properties=new Properties();
        // bean.properties 必须在src 根目录下

        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    加载需要的 实现类

     */

    public static<T> T  getImpl(Class<T> clazz){


         String key =  clazz.getSimpleName();
         String className = properties.getProperty(key);
        try {
            return (T) Class.forName(className).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
