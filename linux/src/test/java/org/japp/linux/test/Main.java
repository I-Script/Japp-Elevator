package org.japp.linux.test;

import org.japp.linux.Japp;

public class Main {
    public static void main(String[] args) {
        if(Japp.elevateApplication()) return;

        System.out.println("Application now launched as administrator.");
    }
}
