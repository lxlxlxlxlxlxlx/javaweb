package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (Exception e) {

        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties properties,String key){
        return getInt(properties,key,0);
    }

    public static int getInt(Properties properties,String key, int defaultValue){
        int value = defaultValue;
        if(properties.containsKey(key)){
           // value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }
}
