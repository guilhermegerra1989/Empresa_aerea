package br.com.guilherme.lemes.common.util;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LoggerUtil {

    private static boolean initialized;

    private static Properties properties;

    public static void initLog() {
        if (initialized)
            return;

        try {
            properties = new Properties();
            properties.load(LoggerUtil.class.getResourceAsStream("/properties/log4j.properties"));

            File logDir = new File(properties.getProperty("log4j.dir"));

            if (!logDir.exists())
                logDir.mkdir();

            PropertyConfigurator.configure(properties);
            initialized = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createLog(String name){
        if(CommonUtil.isNullOrEmpty(name))
            return;

        StringBuilder logName = new StringBuilder(name);
        logName.append(".log");

        Logger loggerRoot = Logger.getRootLogger();
        Appender appender = loggerRoot.getAppender("OPERATION");
        if (appender != null && appender instanceof FileAppender) {
            FileAppender roll = (FileAppender) appender;
            roll.setFile(String.format("%s%s%s", properties.getProperty("log4j.dir"), File.separator, logName.toString()));
            roll.activateOptions();
        }
    }
}
