package org.example;

import org.springframework.stereotype.Component;

@Component
public class Firefly implements Lighter {
    public Firefly() {}
    @Override
    public void dolight() {
        System.out.println("Firefly is shining");
    }
}
