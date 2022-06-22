package com.chakrawaat.beans.tyres;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgeStoneTyre implements Tyres{
    @Override
    public void rotate() {
        System.out.println("BridgeStoneTyre is rotating.");
    }
}
