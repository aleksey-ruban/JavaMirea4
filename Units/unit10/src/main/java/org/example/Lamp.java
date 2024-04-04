package org.example;

import org.springframework.stereotype.Component;

@Component
public class Lamp implements Lighter {
    public Lamp() {}
    @Override
    public void dolight() {
        System.out.println("Lamp is shining");
    }
}
