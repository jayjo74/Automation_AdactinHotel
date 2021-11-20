package com.utils;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.exception.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

    //Converting all property data to Hashmap - it is more fast
    //When it start the test, at first it will put all data in Hashmap
    //in static block, have to use try catch, not customize throw error
    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(file);
            for(Map.Entry<Object, Object> entry: property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
            }
        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String get(ConfigProperties key) {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties.");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    //Hashtable - little slow, thread safe put everything in Hashmap
    //converting a property to hashmap needs some time
//    public static String getValue(String key) throws Exception {
//        if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)){
//            throw new Exception("Property name "+key+" is not found. Please check config.properties");
//        }
//        return property.getProperty(key);
//    }

}
