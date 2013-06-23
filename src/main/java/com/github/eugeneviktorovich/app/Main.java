package com.github.eugeneviktorovich.app;

import com.github.eugeneviktorovich.utils.Collector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eugene Viktorovich
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Collector test = (Collector) context.getBean("collector");

        test.run();
    }
}
