package ru.marketplace;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class SpringMain {

    public static void main(String[] args) {

        try(ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "spring/spring-app.xml", "spring/spring-db.xml")) {
            Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);

        }
    }
}
