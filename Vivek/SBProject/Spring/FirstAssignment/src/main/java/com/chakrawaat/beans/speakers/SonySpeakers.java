package com.chakrawaat.beans.speakers;

import org.springframework.stereotype.Component;

@Component
public class SonySpeakers implements Speakers {

    @Override
    public void makeSound() {
        System.out.println("Sony Speaker making sound.");
    }
}
