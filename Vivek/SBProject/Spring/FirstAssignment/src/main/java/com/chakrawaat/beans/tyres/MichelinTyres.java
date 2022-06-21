package com.chakrawaat.beans.tyres;

import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres{
    @Override
    public void rotate() {
        System.out.println("MichelinTyres is rotating.");
    }
}
