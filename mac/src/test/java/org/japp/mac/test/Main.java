package org.japp.mac.test;

import org.japp.mac.Japp;

public class Main {
    public static void main(String[] args) {
        if(Japp.elevateApplication()) return;

        System.out.println("Application now launched as administrator.");
    }
}
