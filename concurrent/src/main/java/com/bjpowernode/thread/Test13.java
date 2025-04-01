package com.bjpowernode.thread;

import java.io.InputStream;
import java.util.Properties;

/**
 * 线程getContextClassLoader()
 *
 */
public class Test13 {

    public static void main(String[] args) throws Exception {

        System.out.println(Test13.class.getClassLoader());

        Properties properties = new Properties();
        //InputStream is = String.class.getClassLoader().getResourceAsStream("config.properties");
        //InputStream is = Test13.class.getClassLoader().getResourceAsStream("config.properties");
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        properties.load(is);
        System.out.println(properties.getProperty("name"));

        //Thread.currentThread().setContextClassLoader(xxx);
    }
}