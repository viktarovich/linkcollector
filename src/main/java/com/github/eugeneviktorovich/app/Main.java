package com.github.eugeneviktorovich.app;

import com.github.eugeneviktorovich.utils.Collector;
import com.skype.SkypeException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main application.
 *
 * @author Eugene Viktorovich
 */
public class Main {

    public static void main(String[] args) throws SkypeException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Collector collector = (Collector) context.getBean("collector");

        collector.run();
    }
}
