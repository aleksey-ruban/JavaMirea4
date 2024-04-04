package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Unit10 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Lamp lamp = context.getBean(Lamp.class);
        lamp.dolight();

        Flashlight flashlight = context.getBean(Flashlight.class);
        flashlight.dolight();

        Firefly firefly = context.getBean(Firefly.class);
        firefly.dolight();
    }
}