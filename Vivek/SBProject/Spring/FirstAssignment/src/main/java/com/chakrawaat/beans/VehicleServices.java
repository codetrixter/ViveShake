package com.chakrawaat.beans;

import com.chakrawaat.beans.speakers.Speakers;
import com.chakrawaat.beans.tyres.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {


    @Autowired
    private Speakers speaker;

    @Autowired
    private Tyres tyre;

    @Autowired
    public VehicleServices(Speakers speaker, Tyres tyre) {
        this.speaker = speaker;
        this.tyre = tyre;
    }

    public void makeSound() {
        speaker.makeSound();
    }

    public void rotate() {
        tyre.rotate();
    }
}
