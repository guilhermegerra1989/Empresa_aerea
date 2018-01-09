package br.com.guilherme.lemes.common.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;

public class SpringUtil {

    private static ClassPathXmlApplicationContext applicationContext;

    private static URL file = SpringUtil.class.getResource("/spring/applicationContext.xml");

    public static <T> T getInstance(Class<T> clazz) {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext(file.toExternalForm());
            applicationContext.registerShutdownHook();
        }

        return applicationContext.getBean(clazz);
    }


    public static void close() {
        applicationContext.close();
        applicationContext = null;
    }
}
