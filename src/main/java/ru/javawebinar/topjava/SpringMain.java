package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Oleksandr on 15.12.15.
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n"+ Arrays.toString(applicationContext.getBeanDefinitionNames()) + "\n");
        applicationContext.close();
    }


}
