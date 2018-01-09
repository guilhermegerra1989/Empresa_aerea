package br.com.guilherme.lemes.common.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

    private static Logger logger = Logger.getLogger(PropertiesUtil.class);

    private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

    public static String getValue(PropertyEnum propertyEnum) {
        Properties properties = new Properties();

        if (!propertiesMap.containsKey(propertyEnum.getFileName())) {
            String fileName = "/properties/" + propertyEnum.getFileName();

            try {
                properties.load(PropertiesUtil.class.getResourceAsStream(fileName));
                propertiesMap.put(propertyEnum.getFileName(), properties);
            } catch (IOException e) {
                logger.error(String.format("Error while trying to load \"%s\".", fileName), e);
            }
        } else {
            properties = propertiesMap.get(propertyEnum.getFileName());
        }

        if (properties.containsKey(propertyEnum.getKey()))
            return (String) properties.get(propertyEnum.getKey());

        return null;
    }
}
