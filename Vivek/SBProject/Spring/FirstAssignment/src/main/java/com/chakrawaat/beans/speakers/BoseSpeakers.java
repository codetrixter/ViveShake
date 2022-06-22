package com.chakrawaat.beans.speakers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BoseSpeakers implements Speakers{
    @Override
    public void makeSound() {
        System.out.println("Bose Speaker making sound!");
    }
}
