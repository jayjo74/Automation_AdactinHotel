package com.utils;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {

    private JsonUtils(){}

    private static Map<String, String> CONFIGMAP = new HashMap<>();

    /**
     * Converting all property data to Hashmap - it is more fast
     * When it start the test, at first it will put all data in Hashmap
     */

    static {
        try {
            CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigPath()), HashMap.class);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property name " + key + " is not found. Please check config.properties.");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

}
