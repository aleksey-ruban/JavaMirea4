package org.example;

import org.springframework.stereotype.Component;

@Component
public class Flashlight implements Lighter {
    public Flashlight() {}
    @Override
    public void dolight() {
        System.out.println("Flashlight is shining");
    }
}
