package com.example;

import io.micronaut.runtime.Micronaut;
import reactor.blockhound.BlockHound;

public class Application {
    public static void main(String[] args) {

        BlockHound.install();
        Micronaut.run(Application.class, args);
    }
}
